package com.fh.xk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	private static Connection conn;
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String URL ="jdbc:mysql://localhost:3306/xuanke";
	public static final String USERNAME ="root";
	public static final String PASSWORD = "root";
	
	static{
		try {
			Class.forName(DRIVER);
			//2.�������ݿ�����
			 conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Connection getConn() {
		return conn;
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection conn){
		if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		if(conn !=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	




}
