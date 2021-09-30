package com.farm.Model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.farm.Bean.CropBean;
import com.farm.utility.DBConnect;

public class CropDAO {

	public int addCrop(CropBean bean) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=DBConnect.getConn();
		String sql="INSERT INTO F_CROPS (CNAME,SMONTH,EMONTH,CIMAGE,CDESC) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1, bean.getCrop_name());
		/*preparedStatement.setString(2, bean.getCrop_month());*/
		preparedStatement.setString(2, bean.getStart_month());
		preparedStatement.setString(3, bean.getEnd_month());
		preparedStatement.setString(4, bean.getImage());
		preparedStatement.setString(5, bean.getCrop_desc());
		int i=preparedStatement.executeUpdate();
		if(i>0)
		{
			return i;
		}
		return i;
	}
	
	public static CropBean getRecordById(int id) throws SQLException
	{
		CropBean bean=new CropBean();
		Connection con = DBConnect.getConn();
		String sql = "SELECT * FROM F_CROPS where ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next())
		{
			bean.setId(rs.getInt(1));
			bean.setCrop_name(rs.getString(2));
			//bean.setCrop_month(rs.getString(3));
			bean.setStart_month(rs.getString(5));
			bean.setEnd_month(rs.getString(6));
			bean.setImage(rs.getString(3));
			bean.setCrop_desc(rs.getString(4));
		}
		return bean;
		
	}

	public int editCrops(CropBean bean2) throws SQLException {
		System.out.println("hello");
		Connection con = DBConnect.getConn();
		String sql = "UPDATE F_CROPS SET CIMAGE=? WHERE ID=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		
		preparedStatement.setString(1, bean2.getImage());
		preparedStatement.setInt(2, bean2.getId());
		int status=preparedStatement.executeUpdate();
		if(status>0)
		{
			return 1;
		}
		
		return 0;
		// TODO Auto-generated method stub
		
	}

}
