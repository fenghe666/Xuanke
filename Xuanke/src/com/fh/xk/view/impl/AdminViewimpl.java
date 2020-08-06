package com.fh.xk.view.impl;

import java.util.Scanner;

import com.fh.xk.dao.AdminDAO;
import com.fh.xk.dao.impl.AdminDAOimpl;
import com.fh.xk.po.Admin;
import com.fh.xk.view.AdminView; 



public class AdminViewimpl implements AdminView {
//	private Scanner input = new Scanner(System.in);
	Scanner input  = new Scanner(System.in);
	@Override
	public Admin adminLogin() {
		// TODO Auto-generated method stub
		System.out.println("请输入管理员账号：");
		String adminName = input.next();
//		String adminName=input.next();
		System.out.println("请输入管理员密码：");
		String password = input.next();
//		String password=input.next();
		
		//璋冪敤adminDAO涓嬬殑鐧诲綍鏂规硶
		AdminDAO adao=new AdminDAOimpl();
		
		
		return adao.adminLogin(adminName, password);
	}

}
