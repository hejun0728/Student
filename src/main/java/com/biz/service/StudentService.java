package com.biz.service;

import java.util.List;

import com.biz.entity.Student;

public interface StudentService {

	/**
	 * ���ѧ��
	 * @param student
	 * @return
	 */
	public int addStudent(Student student);
	/**
	 * ɾ��ѧ��
	 * @param id
	 * @return
	 */
	
	public Long deleteStudent(String id);
	/** 
	 * �޸�ѧ����Ϣ
	 * @param student
	 */
	public void updateStudent(Student student);
	/**
	 * ��ѯѧ����Ϣ
	 * @param id
	 * @return
	 */
	public Student getById(String id);
	/**
	 * ��ȡҳ��
	 * @param cur_page
	 * @return
	 */
	public List<Student> getOnePage(int cur_page);
	/**
	 * ��ȡ��ҳ��
	 * @return
	 */
	public int getTotalPage();
	
}