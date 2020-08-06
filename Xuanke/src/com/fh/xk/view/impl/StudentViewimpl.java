package com.fh.xk.view.impl;

import java.util.List;
import java.util.Scanner;

import com.fh.xk.dao.AdminDAO;
import com.fh.xk.dao.StudentDAO;
import com.fh.xk.dao.TeacherDAO;
import com.fh.xk.dao.impl.AdminDAOimpl;
import com.fh.xk.dao.impl.StudentDAOimpl;
import com.fh.xk.dao.impl.TeacherDAOimpl;
import com.fh.xk.po.Course;
import com.fh.xk.po.Student;
import com.fh.xk.view.StudentView;

public class StudentViewimpl implements StudentView {
	private Scanner input = new Scanner(System.in);
	private StudentDAO sdao= new StudentDAOimpl();
	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("请输入学生姓名：");
		String studentName = input.next();
		System.out.println("请输入学生专业班级：");
		String studentClass = input.next();
		int count = sdao.addStudent(studentName, studentClass);
		if(count>0){
			System.out.println("学生注册成功！ 学生账号为"+count);
		}else{
			System.out.println("学生注册失败！");
		}
		
	}
	@Override
	public Student studentLogin() {
		// TODO Auto-generated method stub
		System.out.println("请输入学生账号：");
		int studentId = input.nextInt();
//		String adminName=input.next();
		System.out.println("请输入学生姓名：");
		String studentName = input.next();
//		String password=input.next();
		
		//璋冪敤adminDAO涓嬬殑鐧诲綍鏂规硶
		StudentDAO sdao=new StudentDAOimpl();
		
		
		return sdao.studentLogin(studentId, studentName);
	}
	@Override
	public void insertCourse(int studentId) {
		// TODO Auto-generated method stub
		System.out.println("请输入要选择的课程编号：");
		int CourseId = input.nextInt();
		int StudentID=studentId;
		int count = sdao.insertCourse(studentId, CourseId);
		if(count>0){
			System.out.println("学生选课成功");
		}else{
			System.out.println("学生选课失败！");
		}
	}
	@Override
	public void listCourse(int studentId) {
		// TODO Auto-generated method stub
		List<Course> clist=sdao.listCourse(studentId);
		for(Course course:clist){
			System.out.println("1"+course.toString());
		}
		
	}
		
	

}
