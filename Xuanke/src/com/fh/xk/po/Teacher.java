package com.fh.xk.po;

public class Teacher {
	private Integer teacherID;
	private String teacherName;
	private String technology;
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public Teacher(Integer teacherID, String teacherName, String technology) {
		super();
		this.teacherID = teacherID;
		this.teacherName = teacherName;
		this.technology = technology;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "教师编号" + teacherID + ", 教师姓名" + teacherName + ",技术方向" + technology;
	}
	
 
}
