package com.fh.xk.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fh.xk.dao.CourseDAO;
import com.fh.xk.po.Course;
import com.fh.xk.po.Student;
import com.fh.xk.util.BaseDAO;

public class CourseDAOimpl extends BaseDAO implements CourseDAO {

	@Override
	public int addCourse(int courseId, String courseName, int courseHour, int teacherId) {
		// TODO Auto-generated method stub
		String sql = "insert into course(CourseId,CourseName,CourseHour,TeacherId) values(?,?,?,?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;
		try {
			pstmt=getConn().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, courseId);
			pstmt.setString(2, courseName);
			pstmt.setInt(3, courseHour);
			pstmt.setInt(4,teacherId);
			count=pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			/*if(rs.next()){
				return rs.getInt(1);
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return count;
	}

	@Override
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
				String sql = "update course set coursename= ?,CourseHour = ? where courseid = ?";
				PreparedStatement pstmt = null;
				int count = 0;
				try {
					pstmt = getConn().prepareStatement(sql);
					pstmt.setString(1, course.getCourseName());
					pstmt.setInt(2, course.getCourseHour());
					pstmt.setInt(3, course.getCourseId());
					count = pstmt.executeUpdate();
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					close(null, pstmt, null);
				}
				return count;
			}

	@Override
	public int deleteCourse(int courseId) {
		// TODO Auto-generated method stub
				String sql1 = "delete from stucou where courseid = ? ";
				String sql2 = "delete from course where courseid = ? ";
				PreparedStatement pstmt = null;
				int count = 0;
				try {
					getConn().setAutoCommit(false);
					pstmt = getConn().prepareStatement(sql1);
					pstmt.setInt(1, courseId);
					count = pstmt.executeUpdate();
				
					pstmt = getConn().prepareStatement(sql2);
					pstmt.setInt(1, courseId);
					count = pstmt.executeUpdate();
					getConn().commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					try {
						getConn().rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}finally{
					close(null, pstmt, null);
				}
				return count;
			}

	@Override
	public Course courseById(int courseId) {
		String sql = "select Courseid ,Coursename,Coursehour,teacherid from Course where courseid = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Course c = null;
		try {
			pstmt = getConn().prepareStatement(sql);
			pstmt.setInt(1, courseId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				c = new Course();
				c.setCourseHour(rs.getInt("Coursehour"));
				c.setCourseId(rs.getInt("Courseid"));
				c.setCourseName(rs.getString("Coursename"));
				c.setTeacherID(rs.getInt("teacherid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return c;
	}

	@Override
	public List<Course> listCourseAll() {
		String sql = "select Courseid ,Coursename,Coursehour,teacherid from Course ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Course> clist = new ArrayList<Course>();
		try {
			pstmt = getConn().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Course c = new Course();
				c.setCourseHour(rs.getInt("Coursehour"));
				c.setCourseId(rs.getInt("Courseid"));
				c.setCourseName(rs.getString("Coursename"));
				c.setTeacherID(rs.getInt("teacherid"));
				clist.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs, pstmt, null);
		}
		return clist;
	}

	@Override
	public List<Student> listCourse_student(int courseId) {
		// TODO Auto-generated method stub
				String sql = "select s.Studentid ,s.Studentname,s.StudentClass from student s,stucou sc,course c "
						+ "where  c.courseId = sc.courseId and s.studentId = sc.studentId and c.courseId = ?";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<Student> slist = new ArrayList<Student>();
				try {
					pstmt = getConn().prepareStatement(sql);
					pstmt.setInt(1, courseId);
					rs = pstmt.executeQuery();
					while(rs.next()){
						Student student = new Student();
						student.setStudentId(rs.getInt("studentid"));
						student.setStudentName(rs.getString("studentname"));
						student.setStudentClass(rs.getString("studentclass"));
						slist.add(student);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					close(rs, pstmt, null);
				}
				return slist;
			}
	

}
