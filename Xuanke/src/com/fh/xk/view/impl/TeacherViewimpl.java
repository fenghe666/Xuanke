package com.fh.xk.view.impl;

import java.util.List;
import java.util.Scanner;

import com.fh.xk.dao.TeacherDAO;
import com.fh.xk.dao.impl.TeacherDAOimpl;
import com.fh.xk.po.Student;
import com.fh.xk.po.Teacher;
import com.fh.xk.view.TeacherView;

public class TeacherViewimpl implements TeacherView {
	private Scanner input = new Scanner(System.in);
private TeacherDAO tdao= new TeacherDAOimpl();
	@Override
	public void addTeacher() {
		// TODO Auto-generated method stub
		System.out.println("�������ʦ������");
		String teacherName = input.next();
		System.out.println("�������ʦ��������");
		String technology = input.next();
		int count = tdao.addTeacher(teacherName, technology);
		if(count>0){
			System.out.println("��ӽ�ʦ�ɹ���");
		}else{
			System.out.println("��ӽ�ʦʧ�ܣ�");
		}
		
		
		
	}
	@Override
	public void updateTeacher() {
		// TODO Auto-generated method stub
		System.out.println("�Ƿ���Ҫ�����ʦ�ؼ��ʣ�(y/n)");
		String inStr=null;
		String teacherName = null;
		String technology=null;
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�����ʦ�ؼ���");
			 teacherName=input.next();
		}
		System.out.println("�Ƿ���Ҫ�����ʦ��������ؼ��ʣ�(y/n)");
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�����ʦ��������ؼ���");
			technology=input.next();
		}
		List<Teacher> tlist = tdao.listTeacher(teacherName, technology);
		Teacher tv = tlist.get(0);
		System.out.println(tv.toString());
		String str = null;
		System.out.println("�Ƿ��޸Ľ�ʦ������(y/n)");
		str=input.next();
		if(str.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�µĽ�ʦ����");
			 teacherName=input.next();
			 tv.setTeacherName(teacherName);
		}
		System.out.println("�Ƿ��޸Ľ�ʦ��������(y/n)");
		str=input.next();
		if(str.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�µĽ�ʦ��������");
			technology=input.next();
			tv.setTechnology(technology);
		}
		int count = tdao.updateTeacher(tv);
		if(count>0){
			System.out.println("��ʦ��Ϣ�޸ĳɹ���");
		}else{
			System.out.println("��ʦ��Ϣ�޸�ʧ�ܣ�");
		}
		
		
	}
	@Override
	public void listTeacher() {
		// TODO Auto-generated method stub
		System.out.println("�Ƿ���Ҫ�����ʦ�ؼ��ʣ�(y/n)");
		String inStr=null;
		String teacherName = null;
		String technology=null;
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�����ʦ�ؼ���");
			 teacherName=input.next();
		}
		System.out.println("�Ƿ���Ҫ�����ʦ��������ؼ��ʣ�(y/n)");
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�����ʦ��������ؼ���");
			technology=input.next();
		}
		List<Teacher> tlist = tdao.listTeacher(teacherName, technology);
		for(Teacher tea:tlist){
			System.out.println(tea.toString());
		}
	}
	@Override
	public void deleteTeacher() {
		// TODO Auto-generated method stub
		System.out.println("�Ƿ���Ҫ�����ʦ�ؼ��ʣ�(y/n)");
		String inStr=null;
		String teacherName = null;
		String technology=null;
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�����ʦ�ؼ���");
			 teacherName=input.next();
		}
		System.out.println("�Ƿ���Ҫ�����ʦ��������ؼ��ʣ�(y/n)");
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("����Ҫ�����ʦ��������ؼ���");
			technology=input.next();
		}
		List<Teacher> tlist = tdao.listTeacher(teacherName, technology);
		for(Teacher tea:tlist){
			System.out.println(tea.toString());
		}
		System.out.println("������Ҫ����Ľ�ʦ��ţ�");
		int teacherId=input.nextInt();
		int count=tdao.deleteTeacher(teacherId);
		if(count>0){
			System.out.println("ɾ����ʦ��Ϣ�ɹ�");
		}else{
			System.out.println("ɾ����ʦ��Ϣʧ��");
		}
		
		
		
		
	}
	@Override
	public void selectStudent() {
		// TODO Auto-generated method stub
		List<Teacher> tlist = tdao.listTeacher(null, null);
		System.out.println("�������ʦ��ţ�");
		int teacherId = input.nextInt();
		List<Student> slist = tdao.selectStudent(teacherId);
		System.out.println("ѧ����ţ�\tѧ������\tרҵ�༶");
		for(Student student:slist){
			System.out.println(student.toString());
		}
		
		
	}

}
