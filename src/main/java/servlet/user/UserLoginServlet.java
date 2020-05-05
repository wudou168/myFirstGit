package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String uname = request.getParameter("uname").trim();
		String upassword = request.getParameter("upassword").trim();
		User user = new User(uname,upassword,null);
		IUserService us = new UserServiceImpl();
		 user = us.queryUser(user);
		 PrintWriter pw = response.getWriter();
		 if(user != null) {
			 request.getRequestDispatcher("StudentsShowServlet").forward(request, response);
		 }else {
			 pw.println("<html>");
			 pw.println("<body");
			 pw.write("该用户不存在\r\n");
			 pw.println("<button onclick=\"window.location.href='login.jsp'\">重新登录</button>");
			 pw.println("</body>");
			 pw.println("</html>");
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
