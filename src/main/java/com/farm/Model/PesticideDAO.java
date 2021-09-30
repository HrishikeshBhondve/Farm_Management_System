package com.farm.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.farm.Bean.InsecticideBean;
import com.farm.Bean.PesticideBean;
import com.farm.utility.DBConnect;

public class PesticideDAO {
	public int addPesticide(PesticideBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO F_PESTICIDE (PNAME,PRANGE,IMAGE,PDESC) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getPname());
		preparedStatement.setString(2, bean.getPrange());
		preparedStatement.setString(3, bean.getImage());
		preparedStatement.setString(4, bean.getPdesc());
		int i=preparedStatement.executeUpdate();
		if(i>0)
		{
			return i;
		}
		return i;
	}
	
	public static PesticideBean getRecordById(int id) throws SQLException
	{
		PesticideBean bean=new PesticideBean();
		Connection con = DBConnect.getConn();
		String sql = "SELECT * FROM F_PESTICIDE where ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			bean.setId(rs.getInt(1));
			bean.setPname(rs.getString(2));
			bean.setPrange(rs.getString(3));
			
			bean.setPdesc(rs.getString(5));
			bean.setImage(rs.getString(4));
		}
		return bean;
		
	}

	public int editPesticide(PesticideBean bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		Connection con = DBConnect.getConn();
		String sql = "UPDATE f_pesticide SET PRANGE=?,IMAGE=? WHERE ID=?";
		//String sql = "UPDATE f_insecticide SET IRANGE=?,IMAGE=? WHERE ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		
		preparedStatement.setString(1, bean2.getPrange());
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
