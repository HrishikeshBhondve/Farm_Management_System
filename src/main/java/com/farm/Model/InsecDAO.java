package com.farm.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.farm.Bean.InsecticideBean;
import com.farm.utility.DBConnect;

public class InsecDAO {

	public int addInsecticide(InsecticideBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO F_INSECTICIDE (INAME,IRANGE,IMAGE,IDESC) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getIname());
		preparedStatement.setString(2, bean.getIrange());
		preparedStatement.setString(3, bean.getImage());
		preparedStatement.setString(4, bean.getIdesc());
		int i=preparedStatement.executeUpdate();
		if(i>0)
		{
			return i;
		}
		return i;
	}
	
	public static InsecticideBean getRecordById(int id) throws SQLException
	{
		InsecticideBean bean=new InsecticideBean();
		Connection con = DBConnect.getConn();
		String sql = "SELECT * FROM F_INSECTICIDE where ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			bean.setId(rs.getInt(1));
			bean.setIname(rs.getString(2));
			bean.setIrange(rs.getString(3));
			
			bean.setIdesc(rs.getString(4));
			bean.setImage(rs.getString(5));
		}
		return bean;
		
	}

	public int editInsec(InsecticideBean bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		Connection con = DBConnect.getConn();
		String sql = "UPDATE f_insecticide SET IRANGE=?,IMAGE=? WHERE ID=?";
		//String sql = "UPDATE f_insecticide SET IRANGE=?,IMAGE=? WHERE ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		
		preparedStatement.setString(1, bean2.getIrange());
		preparedStatement.setString(2, bean2.getImage());
		preparedStatement.setInt(3, bean2.getId());
		int status=preparedStatement.executeUpdate();
		if(status>0)
		{
			return 1;
		}
		
		return 0;
		// TODO Auto-generated method stub
	}
		

		
	}


