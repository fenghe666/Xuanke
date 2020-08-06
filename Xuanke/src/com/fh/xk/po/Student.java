package com.fh.xk.po;

public class Student {
	private Integer studentId;
	private String StudentName;
	private String StudentClass;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentClass() {
		return StudentClass;
	}
	public void setStudentClass(String studentClass) {
		StudentClass = studentClass;
	}
	public Student(Integer studentId, String studentName, String studentClass) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		StudentClass = studentClass;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "学生编号" + studentId + ", 学生姓名" + StudentName + ", 专业班级" + StudentClass;
	}
	

}
