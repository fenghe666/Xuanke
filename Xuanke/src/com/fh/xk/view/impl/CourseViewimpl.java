package com.fh.xk.view.impl;

import java.util.List;
import java.util.Scanner;

import com.fh.xk.dao.CourseDAO;
import com.fh.xk.dao.impl.CourseDAOimpl;
import com.fh.xk.po.Course;
import com.fh.xk.po.Student;
import com.fh.xk.view.CourseView;

public class CourseViewimpl implements CourseView {
	private Scanner input=new Scanner(System.in);
	private CourseDAO cdao = new CourseDAOimpl();
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		int CourseId =0;
		String CourseName=null;
		int CourseHour=0;
		int TeacherId=0;
		System.out.println("请输入课程编号：");
		CourseId=input.nextInt();
		System.out.println("请输入课程名称：");
		CourseName=input.next();
		System.out.println("请输入课程学时：");
		CourseHour=input.nextInt();
		System.out.println("请输入教师编号：");
		TeacherId=input.nextInt();
		int count=cdao.addCourse(CourseId, CourseName, CourseHour, TeacherId);
		if(count>0){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		
		
		
		
	}
	@Override
	public void updateCourse() {
		System.out.println("请输入您要修改的课程编号:");
		int courseId = input.nextInt();
		Course course = cdao.courseById(courseId);
		
		if(course == null){
			System.out.println("没有您要修改的课程信息");
		}else{
			String str = null;
			System.out.println(course.toString());
			System.out.println("是否修改课程名称?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("请输入新的课程名称:");
				String courseName = input.next();
				course.setCourseName(courseName);
			}
			System.out.println("是否此课程对应课时?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("请输入新的课程课时:");
				int courseHour = input.nextInt();
				course.setCourseHour(courseHour);
			}
			
			int count = cdao.updateCourse(course);
			if(count > 0){
				System.out.println("课程信息修改成功！");
			}else{
				System.out.println("课程信息修改失败！");
			}
		}
	}
	@Override
	public void deleteCourse() {
		System.out.println("请输入您要删除的课程编号:");
		int courseId = input.nextInt();
		Course course = cdao.courseById(courseId);
		System.out.println("是否确认要删除此课程?(y/n)");
		String str = input.next();
		if(str.equalsIgnoreCase("y")){
			if(course == null){
				System.out.println("没有您要删除的课程信息");
			}else{
				int count = cdao.deleteCourse(courseId);
				if(count > 0){
					System.out.println("课程信息删除成功！");
				}else{
					System.out.println("课程信息删除失败！");
				}
			}
		}
		
	}
	@Override
	public void listCourseAll() {
		List<Course> clist = cdao.listCourseAll();
		if(clist.size() == 0){
			System.out.println("目前暂无课程信息");
		}else{
			System.out.println("课程编号\t课程名称\t\t课程课时\t讲授教师");
			for(Course c:clist){
				System.out.println(c.getCourseId()+"\t"+c.getCourseName()+"\t\t"+c.getCourseHour()+"\t"+c.getTeacherID());
			}
		}
	}
	@Override
	public void listCourse_student() {
		// TODO Auto-generated method stub
				System.out.println("请输入您要查看的课程编号:");
				int courseId = input.nextInt();
				Course course= cdao.courseById(courseId);
				if(course == null){
					System.out.println("没有您要查看的课程信息");
				}else{
					List<Student> slist = cdao.listCourse_student(course.getCourseId());
					System.out.println("学生编号\t学生姓名\t专业班级");
					for(Student s:slist){
						System.out.println(s.getStudentId()+"\t"+s.getStudentName()+"\t"+s.getStudentClass());
					}
				}
			}

}
