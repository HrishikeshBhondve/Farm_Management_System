package com.farm.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.farm.Bean.CustomerBean;

import com.farm.utility.DBConnect;
import com.mysql.cj.protocol.Message;

/**
 * Servlet implementation class ChangepasswordCtrl
 */
@WebServlet("/ChangepasswordCtrl")
public class ChangepasswordCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangepasswordCtrl() {
        super();
        // TODO Auto-generated constructor stub
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
		System.out.println("inside change passwd");
		// TODO Auto-generated method stub
		PrintWriter p=response.getWriter();
		HttpSession httpSession=request.getSession();
		CustomerBean bean=new CustomerBean();
	//	int  id=Integer.parseInt(request.getParameter("id"));
		String user=request.getParameter("t2");
		//String olpdpwd=request.getParameter("opwd");
		String newpwd=request.getParameter("npwd");
		String conpwd=request.getParameter("cpwd");
		
		/*if(!newpwd.equals(conpwd))
		{
			String msg="Please match Both the Password";
			request.setAttribute("pass",msg);
			request.getRequestDispatcher("ChangeAdmin.jsp").forward(request, response);
		}*/
		
		Connection con=DBConnect.getConn();
		String sql="UPDATE F_USER SET PASSWORD='"+newpwd+"' WHERE USERNAME = '"+user+"'";
	if(!user.equals("admin"))
	{
		if(!newpwd.equals(conpwd))
		{
			String msg="Please match Both the Password";
			request.setAttribute("pass",msg);
			request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
		}
		System.out.println("in user change password");	
	
	/*	Connection con=DBConnect.getConn();
		String sql="UPDATE F_USER SET PASSWORD='"+newpwd+"' WHERE USERNAME = '"+user+"'";*/
		try {
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			int i=preparedStatement.executeUpdate();
			if(i>0)
			{
			String msg="Password Updated Successfully!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Changepassword.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dao.change("opwd","npwd","cpwd");
	}
	else {
		try {
			if(!newpwd.equals(conpwd))
			{
				String msg="Please match Both the Password";
				request.setAttribute("pass",msg);
				request.getRequestDispatcher("ChangeAdmin.jsp").forward(request, response);
			}
			System.out.println("in admin change password");
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			int i=preparedStatement.executeUpdate();
			if(i>0)
			{
			String msg="Password Updated Successfully!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("ChangeAdmin.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
}
