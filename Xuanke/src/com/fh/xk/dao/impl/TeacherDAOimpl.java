package com.fh.xk.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fh.xk.dao.TeacherDAO;
import com.fh.xk.po.Student;
import com.fh.xk.po.Teacher;
import com.fh.xk.util.BaseDAO;

public class TeacherDAOimpl extends BaseDAO implements TeacherDAO {

	@Override
	public int addTeacher(String teacherName, String technology) {
		// TODO Auto-generated method stub
		String sql = "insert into teacher(teacherName,technology) values(?,?);";
		PreparedStatement pstmt = null;
		int count=0;
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setString(1, teacherName);
			pstmt.setString(2, technology);
			count=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}

	@Override
	public List<Teacher> listTeacher(String teacherName, String technology) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("select teacherID,teacherName,technology from teacher where 1=1 ");
		if(teacherName!=null && teacherName.equals("")){
			sql.append("  and teacherName like '%"+teacherName+"%'");
		}
		if(technology!=null && technology.equals("")){
			sql.append("  and technology like '%"+technology+"%'");
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Teacher> tlist = new ArrayList<Teacher>();
		
		try {
			pstmt=getConn().prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Teacher tea = new Teacher();
				tea.setTeacherID(rs.getInt("teacherID"));
				tea.setTeacherName(rs.getString("teacherName"));
				tea.setTechnology(rs.getString("technology"));
				tlist.add(tea);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tlist;
	}

	@Override
	public int updateTeacher(Teacher tv) {
		// TODO Auto-generated method stub
		String sql = "update teacher set teacherName=?,technology=?;";
		PreparedStatement pstmt = null;
		int count=0;
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setString(1, tv.getTeacherName());
			pstmt.setString(2, tv.getTechnology());
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}

	@Override
	public int deleteTeacher(int teacherId) {
		// TODO Auto-generated method stub
		String sql="delete from stucou where courseId in(select courseID from teacher,course where course.teacherId=teacher.teacherId and teacher.teacherId=?)";
		String sql1="delete from course where teacherId=?";
		String sql2="delete from teacher where teacherId=?";
		PreparedStatement pstmt=null;
		
		try {
			getConn().setAutoCommit(false);
			pstmt=getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherId);
			pstmt.executeUpdate();
			
			pstmt=getConn().prepareStatement(sql1);
			pstmt.setInt(1, teacherId);
			pstmt.executeUpdate();
			
			pstmt=getConn().prepareStatement(sql2);
			pstmt.setInt(1, teacherId);
			int count =pstmt.executeUpdate();
			getConn().commit();
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
	public List<Student> selectStudent(int teacherId) {
		// TODO Auto-generated method stub
		List<Student> slist = new ArrayList<Student>();
		String sql="select student.studentId,studentName,studentClass from student,stucou,course where student.studentId=stucou.studentId and course.courseId=stucou.courseId and course.teacherId=?";
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt=getConn().prepareStatement(sql);
			pstmt.setInt(1, teacherId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentClass(rs.getString("studentClass"));
				slist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return slist;
	}
	

}
