package com.biz.service;

import java.util.List;

import com.biz.entity.Student;

public interface StudentService {

	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	public int addStudent(Student student);
	/**
	 * 删除学生
	 * @param id
	 * @return
	 */
	
	public Long deleteStudent(String id);
	/** 
	 * 修改学生信息
	 * @param student
	 */
	public void updateStudent(Student student);
	/**
	 * 查询学生信息
	 * @param id
	 * @return
	 */
	public Student getById(String id);
	/**
	 * 获取页数
	 * @param cur_page
	 * @return
	 */
	public List<Student> getOnePage(int cur_page);
	/**
	 * 获取总页数
	 * @return
	 */
	public int getTotalPage();
	
}