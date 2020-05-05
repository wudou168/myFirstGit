package org.wudou.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.wudou.service.StudentAddService;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentAddService studentAddService;
	
	
	  public void setStudentAddService(StudentAddService studentAddService) {
		  this.studentAddService = studentAddService;
	  }
	 

	
	  @Override public void init() throws ServletException { //正常JAVA程序这么获取就可以
	  //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //若是web程序最好这种方式
	  ApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(this.getServletContext()) ;
	  	this.studentAddService = (StudentAddService)context.getBean("studentAddService");
	 }
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String result = studentAddService.addStudent("zhangsan8");
		request.setAttribute("name", result);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
