package com.farm.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.farm.Bean.CustomerBean;
import com.farm.utility.DBConnect;

public class CustomerDAO {

	public int registerCustomer(CustomerBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBConnect.getConn();
		String sql="INSERT INTO F_USER (NAME,USERNAME,MOBILE,PASSWORD,EMAIL,CITY,STATE,ADDRESS,ROLEID) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=conn.prepareStatement(sql);
		preparedStatement.setString(1,bean.getName());
		preparedStatement.setString(2, bean.getUsername());
		preparedStatement.setString(3, bean.getMobile());
		preparedStatement.setString(4, bean.getPassword());
		preparedStatement.setString(5, bean.getEmail());
		preparedStatement.setString(6, bean.getCity());
		preparedStatement.setString(7, bean.getState());
		preparedStatement.setString(8, bean.getAddress());
		preparedStatement.setInt(9, bean.getRoleid());
		int result=preparedStatement.executeUpdate();
		System.out.println("statement executed "+result);
		if(result>0)
		{
			return result;
		}
		return result;
		
	}

}
