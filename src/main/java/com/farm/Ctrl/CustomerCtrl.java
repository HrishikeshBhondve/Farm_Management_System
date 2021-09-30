package com.farm.Ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.farm.Bean.CustomerBean;
import com.farm.Model.CustomerDAO;
import com.farm.utility.Validation;

/**
 * Servlet implementation class CustomerCtrl
 */
@WebServlet("/CustomerCtrl")
public class CustomerCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter printWriter=response.getWriter();
		printWriter.print("hi");
		
		/* Take parameter from user*/
		String name=request.getParameter("name");
		String uname=request.getParameter("uname");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String address=request.getParameter("address");
		
		
		/* SET parameter to Bean*/
		CustomerBean bean=new CustomerBean();
		bean.setName(name);
		bean.setUsername(uname);
		bean.setMobile(mobile);
		bean.setPassword(password);
		bean.setEmail(email);
		bean.setCity(city);
		bean.setState(state);
		bean.setAddress(address);
		bean.setRoleid(2);  //for customer I have set role id to 2.
		bean.setPassword(cpass);
		if(!Validation.isValidUsername(name) )
		{
			System.out.println("name ");
			request.setAttribute("namevalidation","Please enter Only characters");
			request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
		}
		else if(!Validation.isValidUsername(uname) )
		{
			System.out.println("name ");
			request.setAttribute("unamevalidation","Please enter Only characters");
			request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
		}
		else if(!Validation.isValidMobile(mobile))
		{
			System.out.println("mobile ");
			request.setAttribute("mobvalidation","Please enter Numbers");
			request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
		}
		else if(!cpass.equals(password))
		{
			System.out.println("password ");
			request.setAttribute("password","Please Match Both the password");
			request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
		}
		if(!Validation.isValidUsername(city) )
		{
			System.out.println("city ");
			request.setAttribute("city","Please enter Only characters");
			request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
		}
		else
		{
			
		
		HttpSession httpSession=request.getSession();
		/* Call DAO class with bean object*/
		CustomerDAO customerDAO=new CustomerDAO();
		try {
			int i=customerDAO.registerCustomer(bean);
			if(i>0)
			{
				System.out.println("registerd");
				String msg="Registerd Successfully";
				
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
			}
			else
			{
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("in here");
			httpSession.setAttribute("ERROR", "USERNAME ALREADY EXIST");
			request.setAttribute("errmsg", "USERNAME ALREADY EXIST");
			//response.sendRedirect("regcustomer.jsp");
			request.getRequestDispatcher("regcustomer.jsp").forward(request, response);
		}    //call for registering customer
		
		
		}
		
	}

}
