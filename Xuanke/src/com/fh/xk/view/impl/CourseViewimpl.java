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
		System.out.println("������γ̱�ţ�");
		CourseId=input.nextInt();
		System.out.println("������γ����ƣ�");
		CourseName=input.next();
		System.out.println("������γ�ѧʱ��");
		CourseHour=input.nextInt();
		System.out.println("�������ʦ��ţ�");
		TeacherId=input.nextInt();
		int count=cdao.addCourse(CourseId, CourseName, CourseHour, TeacherId);
		if(count>0){
			System.out.println("��ӳɹ�");
		}else{
			System.out.println("���ʧ��");
		}
		
		
		
		
	}
	@Override
	public void updateCourse() {
		System.out.println("��������Ҫ�޸ĵĿγ̱��:");
		int courseId = input.nextInt();
		Course course = cdao.courseById(courseId);
		
		if(course == null){
			System.out.println("û����Ҫ�޸ĵĿγ���Ϣ");
		}else{
			String str = null;
			System.out.println(course.toString());
			System.out.println("�Ƿ��޸Ŀγ�����?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("�������µĿγ�����:");
				String courseName = input.next();
				course.setCourseName(courseName);
			}
			System.out.println("�Ƿ�˿γ̶�Ӧ��ʱ?(y/n)");
			str = input.next();
			if(str.equalsIgnoreCase("y")){
				System.out.println("�������µĿγ̿�ʱ:");
				int courseHour = input.nextInt();
				course.setCourseHour(courseHour);
			}
			
			int count = cdao.updateCourse(course);
			if(count > 0){
				System.out.println("�γ���Ϣ�޸ĳɹ���");
			}else{
				System.out.println("�γ���Ϣ�޸�ʧ�ܣ�");
			}
		}
	}
	@Override
	public void deleteCourse() {
		System.out.println("��������Ҫɾ���Ŀγ̱��:");
		int courseId = input.nextInt();
		Course course = cdao.courseById(courseId);
		System.out.println("�Ƿ�ȷ��Ҫɾ���˿γ�?(y/n)");
		String str = input.next();
		if(str.equalsIgnoreCase("y")){
			if(course == null){
				System.out.println("û����Ҫɾ���Ŀγ���Ϣ");
			}else{
				int count = cdao.deleteCourse(courseId);
				if(count > 0){
					System.out.println("�γ���Ϣɾ���ɹ���");
				}else{
					System.out.println("�γ���Ϣɾ��ʧ�ܣ�");
				}
			}
		}
		
	}
	@Override
	public void listCourseAll() {
		List<Course> clist = cdao.listCourseAll();
		if(clist.size() == 0){
			System.out.println("Ŀǰ���޿γ���Ϣ");
		}else{
			System.out.println("�γ̱��\t�γ�����\t\t�γ̿�ʱ\t���ڽ�ʦ");
			for(Course c:clist){
				System.out.println(c.getCourseId()+"\t"+c.getCourseName()+"\t\t"+c.getCourseHour()+"\t"+c.getTeacherID());
			}
		}
	}
	@Override
	public void listCourse_student() {
		// TODO Auto-generated method stub
				System.out.println("��������Ҫ�鿴�Ŀγ̱��:");
				int courseId = input.nextInt();
				Course course= cdao.courseById(courseId);
				if(course == null){
					System.out.println("û����Ҫ�鿴�Ŀγ���Ϣ");
				}else{
					List<Student> slist = cdao.listCourse_student(course.getCourseId());
					System.out.println("ѧ�����\tѧ������\tרҵ�༶");
					for(Student s:slist){
						System.out.println(s.getStudentId()+"\t"+s.getStudentName()+"\t"+s.getStudentClass());
					}
				}
			}

}
