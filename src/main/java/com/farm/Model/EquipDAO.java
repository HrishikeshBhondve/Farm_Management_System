package com.farm.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.farm.Bean.EquipmentBean;

import com.farm.utility.DBConnect;

public class EquipDAO {

	public int addEquipment(EquipmentBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO F_EQUIPMENT (ENAME,ERANGE,IMAGE,EDESC) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getEname());
		preparedStatement.setString(2, bean.getErange());
		preparedStatement.setString(3, bean.getImage());
		preparedStatement.setString(4, bean.getEdesc());
		int i=preparedStatement.executeUpdate();
		if(i>0)
		{
			return i;
		}
		return i;
	}
	public static EquipmentBean getRecordById(int id) throws SQLException
	{
		EquipmentBean bean=new EquipmentBean();
		Connection con = DBConnect.getConn();
		String sql = "SELECT * FROM F_EQUIPMENT where ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			bean.setId(rs.getInt(1));
			bean.setEname(rs.getString(2));
			bean.setErange(rs.getString(3));
			
			bean.setEdesc(rs.getString(4));
			bean.setImage(rs.getString(5));
		}
		return bean;
		
	}

	public int editEquip(EquipmentBean bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		Connection con = DBConnect.getConn();
		//String sql = "UPDATE f_EQUIPMENT SET ERANGE=? WHERE ID=?";
		String sql = "UPDATE f_EQUIPMENT SET ERANGE=?,IMAGE=? WHERE ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		
		preparedStatement.setString(1, bean2.getErange());
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
