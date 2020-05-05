package org.wudou.service;

import org.wudou.dao.StudentAddDao;

public class StudentAddService {
	private StudentAddDao studentAddDao;
	
	public void setStudentAddDao(StudentAddDao studentAddDao) {
		this.studentAddDao = studentAddDao;
	}

	public String addStudent(String name) {
		return studentAddDao.addStudent(name);
	}
}
