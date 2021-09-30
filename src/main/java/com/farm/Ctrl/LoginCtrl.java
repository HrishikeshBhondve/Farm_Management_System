package com.farm.Ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.farm.Bean.CustomerBean;
import com.farm.Model.LoginDAO;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("about.jsp").forward(request, response);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in login");
		if(request.getParameter("Action").equals("Login"))
		{
		HttpSession httpSession=request.getSession();
		CustomerBean bean=new CustomerBean();
		String username=request.getParameter("uname");
		String pass=request.getParameter("pass");
		//bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setUsername(username);
		bean.setPassword(pass);
		LoginDAO dao=new LoginDAO();
		try {
			String result=dao.validateUser(bean);
			if(result.equals("ADMIN_ROLE"))
			{
				
				httpSession.setAttribute("admin", username);
				request.setAttribute("msg", "Welcome");
				response.sendRedirect("adminhome.jsp");
			}
			else if(result.equals("CUSTOMER_ROLE"))
			{
				System.out.println("inside customer role");
				httpSession.setAttribute("user", username);
				request.setAttribute("msg", "Welcome");
				response.sendRedirect("userhome.jsp");
			}
			if(result.equals("INVALID")){
				request.setAttribute("msg","Incorrect Login or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}

}
