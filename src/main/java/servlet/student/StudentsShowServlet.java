package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Paging;
import entity.Student;
import service.IStudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentsShowServlet
 */
public class StudentsShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentsShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IStudentService ss = new StudentServiceImpl();
		Paging p = new Paging();
		p.setTotalRecords(ss.queryTotalRecords());
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if(currentPage == null) {
			currentPage = "1";
		}
		p.setCurrPage(Integer.parseInt(currentPage));
		
		if(pageSize == null) {
			pageSize = "5";
		}
		p.setPageSize(Integer.parseInt(pageSize));
		request.setAttribute("p", p);
		//List<Student> stus = ss.queryStudents();
		List<Student> stus = ss.queryPageStudents(p);
		request.setAttribute("stus", stus);
		
		request.getRequestDispatcher("WEB-INF/student/students_show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
