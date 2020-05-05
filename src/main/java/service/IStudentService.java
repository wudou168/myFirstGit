package service;

import java.util.List;

import entity.Paging;
import entity.Student;

public interface IStudentService {

	public Student queryStudentBySid(int sid);
	public List<Student> queryStudents();
	public int deleteStudentBySid(int sid);
	public int updateStudent(int sid,Student s);
	public int insertStudent(Student s);
	public int queryTotalRecords();
	public List<Student> queryPageStudents(Paging p);
}
