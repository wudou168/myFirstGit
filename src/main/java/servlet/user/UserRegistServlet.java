package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import service.IUserService;
import service.impl.UserServiceImpl;
import util.StringUtil;

/**
 * Servlet implementation class UserRegistServlet
 */
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname").trim();
		String upassword = request.getParameter("upassword").trim();
		String[] uinterests = request.getParameterValues("uinterests");
		User user = new User(uname,upassword,StringUtil.getArrayToString(uinterests));
		IUserService us = new UserServiceImpl();
		response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		int result = us.intsertUser(user);
		PrintWriter pw = response.getWriter();
		if(result>0) {
			 pw.println("<html>");
			 pw.println("<body");
			 pw.write(uname+"注册成功\r\n");
			 pw.println("<button onclick=\"window.location.href='login.jsp'\">去登录</button>");
			 pw.println("</body>");
			 pw.println("</html>");
		}else {
			pw.println("<html>");
			 pw.println("<body");
			 pw.write(uname+"用户已经存在\r\n");
			 pw.write("<button onclick=\"window.location.href='login.jsp'\">去登录</button>\r\n");
			 pw.println("<button onclick=\"window.location.href='UserRegistServlet'\">重新注册</button>");
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
