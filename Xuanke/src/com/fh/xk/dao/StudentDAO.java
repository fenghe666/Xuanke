package com.fh.xk.dao;

import java.util.List;

import com.fh.xk.po.Course;
import com.fh.xk.po.Student;

public interface StudentDAO {
	public int addStudent(String studentName,String studentClass);
	
	public Student studentLogin(int studentId,String studentName);

	public int insertCourse(int studentId,int courseId);
	
	public List<Course> listCourse(int studentId);
}
