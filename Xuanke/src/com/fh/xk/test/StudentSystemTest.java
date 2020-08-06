package com.fh.xk.test;

import java.util.Scanner;

import com.fh.xk.po.Student;
import com.fh.xk.view.StudentView;
import com.fh.xk.view.impl.StudentViewimpl;

public class StudentSystemTest {
	Student student = new Student();
	Scanner input = new Scanner(System.in);
	private StudentView sview = new StudentViewimpl();
	public void work(){
		System.out.println("-------------------------------------------------");
		System.out.println("|\t\t欢迎使用学生选课系统\t\t\t|");
		System.out.println("-------------------------------------------------");
		System.out.println("请选择注册或者登陆：1.注册  2.登陆");
		int num=0;
		while(num!=2){
		num=input.nextInt();
	    switch(num){
	    case 1:
	    	sview.addStudent();
	    	break;
	    case 2:
	    	student=sview.studentLogin();
	    	if(student != null){
	    		System.out.println("------1.学生选课  2.查看已选课程");
	    		 num=input.nextInt();
				    switch(num){
				    case 1:
				    	sview.insertCourse(student.getStudentId());
				    	break;
				    case 2:
				    	
				    	break;
				    default :
				    	System.out.println("没有这个选项");
				    		break;
				    }    		
	    	}else{
	    		System.out.println("登陆失败");
	    	}
	    	break;
	    default :
	    	System.out.println("没有这个选项");
	    		break;
	    }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentSystemTest().work();

	}

}
