package com.fh.xk.view;

import com.fh.xk.po.Student;

public interface StudentView {
	public void addStudent();
	public Student studentLogin();
	
	public void insertCourse(int studentId);
	public void listCourse(int studentId);

}
