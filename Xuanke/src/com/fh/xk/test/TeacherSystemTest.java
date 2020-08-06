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
		System.out.println("|\t\t��ӭʹ�ú�̨����ϵͳ\t\t\t|");
		System.out.println("-------------------------------------------------");
		AdminView aview = new AdminViewimpl();
		TeacherView tview= new TeacherViewimpl();
		Admin admin = aview.adminLogin();
		if(admin != null){
			int num=0;
			while(num!=7){
				System.out.println("-------1.��ʦ���  2.ɾ����ʦ 3.�޸Ľ�ʦ��Ϣ 4.��ѯ��ʦ��Ϣ 5.�鿴��ʦ����ѧ����Ϣ 6.�γ̹��� 7.�˳�ϵͳ--");
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
			    	System.out.println("��ӭ�ٴ�ʹ�ú�̨����ϵͳ");
			    	break;
			    default :
			    	System.out.println("û�����ѡ��");
			    		break;
			    }
			
			}
		}else{
			System.out.println("��¼ʧ��");
		}
		
	}
	
	public void CourseManager(){
		int num=0;
		while(num!=6){
			System.out.println("-------1.�γ����  2.ɾ���γ� 3.�޸Ŀγ���Ϣ 4.��ѯȫ���γ� 5.�鿴�γ��µ�ѧ����Ϣ 6.������һ��--");
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
		    	System.out.println("û�����ѡ��");
		    		break;
		    }
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TeacherSystemTest().work();

	}

}
