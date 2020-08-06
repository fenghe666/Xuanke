package com.fh.xk.test;

import java.util.Scanner;

import com.fh.xk.po.Admin;
import com.fh.xk.view.AdminView;
import com.fh.xk.view.CourseView;
import com.fh.xk.view.TeacherView;
import com.fh.xk.view.impl.AdminViewimpl;
import com.fh.xk.view.impl.CourseViewimpl;
import com.fh.xk.view.impl.TeacherViewimpl;

public class TeacherSystemTest {
	Scanner input = new Scanner(System.in);
	private CourseView cview= new CourseViewimpl();
	public void work(){
		System.out.println("-------------------------------------------------");
		System.out.println("|\t\t欢迎使用后台管理系统\t\t\t|");
		System.out.println("-------------------------------------------------");
		AdminView aview = new AdminViewimpl();
		TeacherView tview= new TeacherViewimpl();
		Admin admin = aview.adminLogin();
		if(admin != null){
			int num=0;
			while(num!=7){
				System.out.println("-------1.教师添加  2.删除教师 3.修改教师信息 4.查询教师信息 5.查看教师所教学生信息 6.课程管理 7.退出系统--");
			    num=input.nextInt();
			    switch(num){
			    case 1:
			    	tview.addTeacher();
			    	break;
			    case 2:
			    	tview.deleteTeacher();
			    	break;
			    case 3:
			    	tview.updateTeacher();
			    	break;
			    case 4:
			    	tview.listTeacher();
			    	break;
			    case 5:
			    	tview.selectStudent();
			    	break;
			    case 6:
			    	CourseManager();
			    	break;
			    case 7:
			    	System.out.println("欢迎再次使用后台管理系统");
			    	break;
			    default :
			    	System.out.println("没有这个选项");
			    		break;
			    }
			
			}
		}else{
			System.out.println("登录失败");
		}
		
	}
	
	public void CourseManager(){
		int num=0;
		while(num!=6){
			System.out.println("-------1.课程添加  2.删除课程 3.修改课程信息 4.查询全部课程 5.查看课程下的学生信息 6.返回上一级--");
		    num=input.nextInt();
		    switch(num){
		    case 1:
		    	cview.addCourse();
		    	break;
		    case 2:
		    	cview.deleteCourse();
		    	break;
		    case 3:
		    	cview.updateCourse();	
		    	break;
		    case 4:
		    	cview.listCourseAll();
		    	break;
		    case 5:
		    	cview.listCourse_student();	
		    	break;
		    
		    case 6:
		    	
		    	break;
		    default :
		    	System.out.println("没有这个选项");
		    		break;
		    }
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherSystemTest().work();

	}

}
