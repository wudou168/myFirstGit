package dao;

import java.util.List;

import entity.Paging;
import entity.Student;

public interface IStudentDao {
	public int delegeStudentBySid(int sid);
	public int updateStudent(int sid,Student s);
	public Student queryStudentBySid(int sid);
	public List<Student> queryStudents();
	public int insertStudent(Student s);
	public Student queryStudentBySno(String sno);
	public int queryTotalRecords();
	public List<Student> queryPageStudents(Paging p);
}
