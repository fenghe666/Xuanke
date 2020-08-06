package com.fh.xk.dao;

import java.util.List;

import com.fh.xk.po.Course;
import com.fh.xk.po.Student;

public interface CourseDAO {
	public int addCourse(int courseId,String courseName,int courseHour,int teacherId);
	
	public int updateCourse(Course course);
	public int deleteCourse(int courseId);
	public Course courseById(int courseId);
	public List<Course> listCourseAll();
	public List<Student> listCourse_student(int courseId);

}
