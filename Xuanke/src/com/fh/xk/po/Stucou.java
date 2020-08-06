package com.fh.xk.po;

public class Stucou {
	private Integer Id;
	private Integer StudentID;
	private Integer CourseID;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getStudentID() {
		return StudentID;
	}
	public void setStudentID(Integer studentID) {
		StudentID = studentID;
	}
	public Integer getCourseID() {
		return CourseID;
	}
	public void setCourseID(Integer courseID) {
		CourseID = courseID;
	}
	public Stucou(Integer id, Integer studentID, Integer courseID) {
		super();
		Id = id;
		StudentID = studentID;
		CourseID = courseID;
	}
	public Stucou() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "±àºÅ" + Id + ", Ñ§Éú±àºÅ" + StudentID + ", ¿Î³Ì±àºÅ" + CourseID + "]";
	}
	

}
