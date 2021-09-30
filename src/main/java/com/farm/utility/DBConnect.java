package com.farm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnect {

	public static Connection getConn() {
		ResourceBundle rd=ResourceBundle.getBundle("system");
		Connection con=null;
		String loadDriver =rd.getString("driver"); // driver name for mysql
		String dbURL =rd.getString("url"); // url of the
															// database
		String dbUSERNAME = rd.getString("userName"); // username to coonect db
		String dbPASSWORD =rd.getString("password"); // password to connect db

		try {
			Class.forName(loadDriver); // load the driver
			con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);// get
																				// the
																				// connection
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
