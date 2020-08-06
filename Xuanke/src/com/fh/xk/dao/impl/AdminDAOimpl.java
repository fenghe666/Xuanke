package com.fh.xk.dao.impl;


import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fh.xk.dao.AdminDAO;
import com.fh.xk.po.Admin;
import com.fh.xk.util.BaseDAO;



public class AdminDAOimpl extends BaseDAO implements AdminDAO {

	@Override
	public Admin adminLogin(String adminName, String password) {
		// TODO Auto-generated method stub
		String sql = "select adminID,adminName,password from admin where adminName=?"
				+ " and password=?";
		Admin admin=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setString(1, adminName);
			pstmt.setString(2, password);
			 rs=pstmt.executeQuery();
			if(rs.next()){
				admin=new Admin();
				admin.setAdminID(rs.getInt("adminID"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setPassword(rs.getString("password"));
				//return admin;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return admin;
		
		
	
	}

	
		
	

}
