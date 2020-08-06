package com.fh.xk.po;

public class Course {
	private Integer CourseId;
	private String CourseName;
	private Integer CourseHour;
	private Integer TeacherID;
	public Integer getCourseId() {
		return CourseId;
	}
	public void setCourseId(Integer courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Integer getCourseHour() {
		return CourseHour;
	}
	public void setCourseHour(Integer courseHour) {
		CourseHour = courseHour;
	}
	public Integer getTeacherID() {
		return TeacherID;
	}
	public void setTeacherID(Integer teacherID) {
		TeacherID = teacherID;
	}
	public Course(Integer courseId, String courseName, Integer courseHour, Integer teacherID) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		CourseHour = courseHour;
		TeacherID = teacherID;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "课程编号" + CourseId + ", 课程名称" + CourseName + ", 课程课时" + CourseHour
				+ ", 对应讲师" + TeacherID ;
	}
	

}
