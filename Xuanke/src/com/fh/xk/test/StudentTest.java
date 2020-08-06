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
		System.out.println("|\t\t��ӭʹ��ѧ��ѡ��ϵͳ\t\t\t|");
		System.out.println("-------------------------------------------------");
		StudentView sview = new StudentViewimpl();
		Student student = null;
		
			int num=0;
			while(num!=3){
				System.out.println("��ѡ��ע����ߵ�½��1.ע��  2.��½ 3.�˳�ϵͳ");
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
			    		System.out.println("��½ʧ��");
			    	}
			    	break;
			    case 3:
			    	System.out.println("��ӭ�ٴ�ʹ��");
			    	break;
			    default :
			    	System.out.println("û�����ѡ��");
			    		break;
			    }
		
			}
	}
	
	public void Course(Student student){
		int num=0;
		while(num!=3){
			System.out.println("-------1.ѧ��ѡ��  2.�鿴��ѡ�γ� 3.�˳�ϵͳ --");
		    num=input.nextInt();
		    switch(num){
		    case 1:
		    	sview.insertCourse(student.getStudentId());
		    	break;
		    case 2:
		    	sview.listCourse(student.getStudentId());
		    	break;
		    case 3:
		    	System.out.println("��ӭ�´�ʹ��");
		    	break;
		    default :
		    	System.out.println("û�����ѡ��");
		    		break;
		    }
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentTest().work();

	}

}
