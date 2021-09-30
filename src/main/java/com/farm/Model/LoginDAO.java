package com.farm.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.farm.Bean.CustomerBean;
import com.farm.utility.DBConnect;

public class LoginDAO {

	public String validateUser(CustomerBean bean) throws SQLException {
		String username=bean.getUsername();
		String password=bean.getPassword();
		int id=bean.getId();
		
		System.out.println("username" +username+"password "+password+ "id is "+id);
		
		Connection con=DBConnect.getConn();
		Statement statement=con.createStatement();
		ResultSet rs=statement.executeQuery("SELECT * FROM F_USER WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'");
		while(rs.next())
		{
			
			String usernamedb=rs.getString("username");
			String passdb=rs.getString("password");
			int roledb=rs.getInt("roleid");
			System.out.println("usernamedb "+usernamedb+"passdb "+passdb);
			if(username.equals(usernamedb) && password.equals(passdb) && roledb==1)
				return "ADMIN_ROLE";
				
			else if (username.equals(usernamedb) && password.equals(passdb) && roledb==2) 
				return "CUSTOMER_ROLE";
		}
		
		return "INVALID";
		// TODO Auto-generated method stub
		
	}

	
}
