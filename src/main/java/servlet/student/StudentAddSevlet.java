package servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.IStudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentAddSevlet
 */
public class StudentAddSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sno = request.getParameter("sno").trim();
		String sname = request.getParameter("sname").trim();
		String semail = request.getParameter("semail").trim();
		String sphone_number = request.getParameter("sphone_number").trim();
		String sclass = request.getParameter("sclass").trim();
		Student s = new Student(0,sno,sname,semail,sphone_number,sclass);
		IStudentService ss = new StudentServiceImpl();
		int result = ss.insertStudent(s);
		if(result>0) {
			request.getRequestDispatcher("StudentsShowServlet").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
