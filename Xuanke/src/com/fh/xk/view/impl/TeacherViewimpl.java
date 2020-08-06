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
		System.out.println("请输入教师姓名：");
		String teacherName = input.next();
		System.out.println("请输入教师技术方向：");
		String technology = input.next();
		int count = tdao.addTeacher(teacherName, technology);
		if(count>0){
			System.out.println("添加教师成功！");
		}else{
			System.out.println("添加教师失败！");
		}
		
		
		
	}
	@Override
	public void updateTeacher() {
		// TODO Auto-generated method stub
		System.out.println("是否需要输入教师关键词？(y/n)");
		String inStr=null;
		String teacherName = null;
		String technology=null;
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("请需要输入教师关键词");
			 teacherName=input.next();
		}
		System.out.println("是否需要输入教师技术方向关键词？(y/n)");
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("请需要输入教师技术方向关键词");
			technology=input.next();
		}
		List<Teacher> tlist = tdao.listTeacher(teacherName, technology);
		Teacher tv = tlist.get(0);
		System.out.println(tv.toString());
		String str = null;
		System.out.println("是否修改教师姓名？(y/n)");
		str=input.next();
		if(str.equalsIgnoreCase("y")){
			System.out.println("请需要新的教师姓名");
			 teacherName=input.next();
			 tv.setTeacherName(teacherName);
		}
		System.out.println("是否修改教师技术方向？(y/n)");
		str=input.next();
		if(str.equalsIgnoreCase("y")){
			System.out.println("请需要新的教师技术方向");
			technology=input.next();
			tv.setTechnology(technology);
		}
		int count = tdao.updateTeacher(tv);
		if(count>0){
			System.out.println("教师信息修改成功！");
		}else{
			System.out.println("教师信息修改失败！");
		}
		
		
	}
	@Override
	public void listTeacher() {
		// TODO Auto-generated method stub
		System.out.println("是否需要输入教师关键词？(y/n)");
		String inStr=null;
		String teacherName = null;
		String technology=null;
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("请需要输入教师关键词");
			 teacherName=input.next();
		}
		System.out.println("是否需要输入教师技术方向关键词？(y/n)");
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("请需要输入教师技术方向关键词");
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
		System.out.println("是否需要输入教师关键词？(y/n)");
		String inStr=null;
		String teacherName = null;
		String technology=null;
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("请需要输入教师关键词");
			 teacherName=input.next();
		}
		System.out.println("是否需要输入教师技术方向关键词？(y/n)");
		inStr=input.next();
		if(inStr.equalsIgnoreCase("y")){
			System.out.println("请需要输入教师技术方向关键词");
			technology=input.next();
		}
		List<Teacher> tlist = tdao.listTeacher(teacherName, technology);
		for(Teacher tea:tlist){
			System.out.println(tea.toString());
		}
		System.out.println("请输入要输入的教师编号：");
		int teacherId=input.nextInt();
		int count=tdao.deleteTeacher(teacherId);
		if(count>0){
			System.out.println("删除教师信息成功");
		}else{
			System.out.println("删除教师信息失败");
		}
		
		
		
		
	}
	@Override
	public void selectStudent() {
		// TODO Auto-generated method stub
		List<Teacher> tlist = tdao.listTeacher(null, null);
		System.out.println("请输入教师编号：");
		int teacherId = input.nextInt();
		List<Student> slist = tdao.selectStudent(teacherId);
		System.out.println("学生编号：\t学生姓名\t专业班级");
		for(Student student:slist){
			System.out.println(student.toString());
		}
		
		
	}

}
