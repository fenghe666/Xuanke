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
		System.out.println("|\t\t��ӭʹ��ѧ��ѡ��ϵͳ\t\t\t|");
		System.out.println("-------------------------------------------------");
		System.out.println("��ѡ��ע����ߵ�½��1.ע��  2.��½");
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
	    		System.out.println("------1.ѧ��ѡ��  2.�鿴��ѡ�γ�");
	    		 num=input.nextInt();
				    switch(num){
				    case 1:
				    	sview.insertCourse(student.getStudentId());
				    	break;
				    case 2:
				    	
				    	break;
				    default :
				    	System.out.println("û�����ѡ��");
				    		break;
				    }    		
	    	}else{
	    		System.out.println("��½ʧ��");
	    	}
	    	break;
	    default :
	    	System.out.println("û�����ѡ��");
	    		break;
	    }
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentSystemTest().work();

	}

}
