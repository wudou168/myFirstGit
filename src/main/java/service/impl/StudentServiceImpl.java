package service.impl;

import java.util.List;

import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import entity.Paging;
import entity.Student;
import service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	private IStudentDao sd = new StudentDaoImpl();
	
	@Override
	public Student queryStudentBySid(int sid) {
		return sd.queryStudentBySid(sid);
	}

	@Override
	public List<Student> queryStudents() {
		return sd.queryStudents();
	}

	@Override
	public int deleteStudentBySid(int sid) {
		return sd.delegeStudentBySid(sid);
	}

	@Override
	public int updateStudent(int sid, Student s) {
		return sd.updateStudent(sid, s);
	}

	@Override
	public int insertStudent(Student s) {
		Student stu = sd.queryStudentBySno(s.getSno());
		if(stu == null) {
			return sd.insertStudent(s);
		}
		return -1;
	}

	@Override
	public int queryTotalRecords() {
		return sd.queryTotalRecords();
	}

	@Override
	public List<Student> queryPageStudents(Paging p) {
		return sd.queryPageStudents(p);
	}

}
