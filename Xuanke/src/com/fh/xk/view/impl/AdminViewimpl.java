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
		System.out.println("���������Ա�˺ţ�");
		String adminName = input.next();
//		String adminName=input.next();
		System.out.println("���������Ա���룺");
		String password = input.next();
//		String password=input.next();
		
		//调用adminDAO下的登录方法
		AdminDAO adao=new AdminDAOimpl();
		
		
		return adao.adminLogin(adminName, password);
	}

}
