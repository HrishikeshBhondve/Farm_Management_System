package com.farm.Ctrl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.farm.Bean.EquipmentBean;
import com.farm.Bean.InsecticideBean;
import com.farm.Model.EquipDAO;
import com.farm.Model.InsecDAO;

/**
 * Servlet implementation class EquipmentCtrl
 */
@WebServlet("/EquipmentCtrl")
@MultipartConfig(maxFileSize = 16177215)
public class EquipmentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipmentCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Action").equals("Add"))
		{
			System.out.println("add");
				EquipmentBean bean=new EquipmentBean();
		String cname=request.getParameter("cname");
		String crange=request.getParameter("range");
		String desc=request.getParameter("desc");
		
		//Part filePart = request.getPart("image");
		
		bean.setEname(cname);
		bean.setErange(crange);
		bean.setEdesc(desc);
		//bean.setImage(filePart);
		bean.setImage(SubImage(request, response));
		
      
          EquipDAO inDao=new EquipDAO();
        try {
			int result=inDao.addEquipment(bean);
			if(result>0)
			{
				request.setAttribute("msg", "Added Successfully");
				request.getRequestDispatcher("addEquip.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(request.getParameter("Action").equals("Edit"))
        {
        	System.out.println("hello");
        	EquipmentBean bean2=new EquipmentBean();
        	bean2.setId(Integer.parseInt(request.getParameter("id")));
        	//bean2.setIname(request.getParameter("cname"));
        	bean2.setErange(request.getParameter("cmonth"));
        	//bean2.setIdesc(request.getParameter("cdesc"));
        	bean2.setImage(SubImage(request, response));
        	/*Part part1=null;
            part1=request.getPart("image");*/
            EquipDAO insecDAO=new EquipDAO();
            try {
				int result=insecDAO.editEquip(bean2);
				if(result>0)
				{
					System.out.println("result is"+result);
					String msg="Edited";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("editequip.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
            
        }
	}

}
