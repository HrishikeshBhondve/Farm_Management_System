package com.farm.Ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.farm.Bean.CropBean;
import com.farm.Model.CropDAO;
import com.mysql.cj.jdbc.Blob;



/**
 * Servlet implementation class CropCtrl
 */
@WebServlet("/CropCtrl")
@MultipartConfig(maxFileSize = 16177215)
public class CropCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CropCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("addcrop.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected String SubImage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResourceBundle rd=ResourceBundle.getBundle("system");
		
		String savePath = rd.getString("path");

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		Part part = request.getPart("image");
		String fileName = extractFileName(part);
		part.write(savePath + File.separator + fileName);
		String filePath = fileName;
		System.out.println("Path----" + savePath + File.separator + fileName);

		return fileName;
	}
	
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Location for uploding file
		if(request.getParameter("Action").equals("Add"))
		{
			System.out.println("add");
				CropBean bean=new CropBean();
		String cname=request.getParameter("cname");
		//String cmonth=request.getParameter("range");
		String desc=request.getParameter("desc");
		String startmonth=request.getParameter("startmonth");
		String endmonth=request.getParameter("endmonth");
		//Part filePart = request.getPart("image");
		
		bean.setCrop_name(cname);
	//	bean.setCrop_month(cmonth);
		bean.setCrop_desc(desc);
		bean.setStart_month(startmonth);
		bean.setEnd_month(endmonth);
		//bean.setImage(filePart);
		bean.setImage(SubImage(request, response));
		
     
          CropDAO cropDAO=new CropDAO();
        try {
			int result=cropDAO.addCrop(bean);
			if(result>0)
			{
				request.setAttribute("msg", "Added Successfully");
				request.getRequestDispatcher("addcrop.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
        if(request.getParameter("Action").equals("Edit"))
        {
        	System.out.println("hello");
        	CropBean bean2=new CropBean();
        	bean2.setId(Integer.parseInt(request.getParameter("id")));
        	//bean2.setCrop_name(request.getParameter("cname"));
        	//bean2.setCrop_month(request.getParameter("cmonth"));
        	//bean2.setCrop_desc(request.getParameter("cdesc"));
        	bean2.setImage(SubImage(request, response));
        	/*Part part1=null;
            part1=request.getPart("image");*/
            CropDAO cropDAO2=new CropDAO();
            try {
				int result=cropDAO2.editCrops(bean2);
				if(result>0)
				{
					System.out.println("result is"+result);
					String msg="Edited";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("editcrop.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
            
        }
		
	}

}
