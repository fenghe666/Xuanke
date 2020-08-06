package com.fh.xk.test;

import java.util.Scanner;

import com.fh.xk.po.Student;
import com.fh.xk.view.CourseView;
import com.fh.xk.view.StudentView;
import com.fh.xk.view.impl.CourseViewimpl;
import com.fh.xk.view.impl.StudentViewimpl;

public class StudentTest {
	private Scanner input = new Scanner(System.in);
	private CourseView cview = new CourseViewimpl();
	private StudentView sview = new StudentViewimpl();

	public void work(){
		System.out.println("-------------------------------------------------");
		System.out.println("|\t\t欢迎使用学生选课系统\t\t\t|");
		System.out.println("-------------------------------------------------");
		StudentView sview = new StudentViewimpl();
		Student student = null;
		
			int num=0;
			while(num!=3){
				System.out.println("请选择注册或者登陆：1.注册  2.登陆 3.退出系统");
				num=input.nextInt();
			    switch(num){
			    case 1:
			    	sview.addStudent();
			    	break;
			    case 2:
			    	student=sview.studentLogin();
			    	if(student!=null){
			    		Course(student);
			    	}else{
			    		System.out.println("登陆失败");
			    	}
			    	break;
			    case 3:
			    	System.out.println("欢迎再次使用");
			    	break;
			    default :
			    	System.out.println("没有这个选项");
			    		break;
			    }
		
			}
	}
	
	public void Course(Student student){
		int num=0;
		while(num!=3){
			System.out.println("-------1.学生选课  2.查看已选课程 3.退出系统 --");
		    num=input.nextInt();
		    switch(num){
		    case 1:
		    	sview.insertCourse(student.getStudentId());
		    	break;
		    case 2:
		    	sview.listCourse(student.getStudentId());
		    	break;
		    case 3:
		    	System.out.println("欢迎下次使用");
		    	break;
		    default :
		    	System.out.println("没有这个选项");
		    		break;
		    }
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentTest().work();

	}

}
