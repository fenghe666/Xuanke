package com.fh.xk.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fh.xk.dao.StudentDAO;
import com.fh.xk.po.Admin;
import com.fh.xk.po.Course;
import com.fh.xk.po.Student;
import com.fh.xk.util.BaseDAO;

public class StudentDAOimpl extends BaseDAO implements StudentDAO {

	@Override
	public int addStudent(String studentName, String studentClass) {
		String sql = "insert into student(studentName,studentClass) values(?,?);";
		PreparedStatement pstmt = null;
		int count=0;
		ResultSet rs=null;
		try {
			pstmt=getConn().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, studentName);
			pstmt.setString(2, studentClass);
			pstmt.executeUpdate();
			rs= pstmt.getGeneratedKeys();
			
			if(rs.next()){
			   return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		  close(null, pstmt, null);
		}
		
		
		
		return 0;
	}

	@Override
	public Student studentLogin(int studentId, String studentName) {
		// TODO Auto-generated method stub
		String sql = "select studentId,studentName from student where studentId=? and  studentName=?";
		Student student=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		try {
			pstmt=getConn().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, studentId);
			pstmt.setString(2, studentName);
			 rs=pstmt.executeQuery();
			 
			if(rs.next()){
				student=new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				
				//return admin;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return student;
	}

	@Override
	public int insertCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		String sql="insert into stucou(studentId,courseId) values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, courseId);
			int count=pstmt.executeUpdate();
			if(count>0){
				return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	@Override
	public List<Course> listCourse(int studentId) {
		// TODO Auto-generated method stub
		String sql = "select course.courseId,courseName,courseHour,TeacherId from course,stucou where stucou.courseId=course.courseId and stucou.studentId=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Course> clist = new ArrayList<Course>();
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setInt(1, studentId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Course course = new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseHour(rs.getInt("courseHour"));
				course.setTeacherID(rs.getInt("TeacherId"));
				clist.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return clist;
	}
		
		
	}


