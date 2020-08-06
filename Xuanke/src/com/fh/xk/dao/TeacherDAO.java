package com.fh.xk.dao;

import java.util.List;

import com.fh.xk.po.Student;
import com.fh.xk.po.Teacher;

public interface TeacherDAO {
	public int addTeacher(String teacherName,String technology);
	
	public List<Teacher> listTeacher(String teacherName,String technology);
	
	public int updateTeacher(Teacher tv);
	public int deleteTeacher(int teacherId);
	public List<Student> selectStudent(int teacherId);

}
