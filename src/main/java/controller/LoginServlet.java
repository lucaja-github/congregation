package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String phonenumber = request.getParameter("phone");
		String password = request.getParameter("password");
		System.out.println("phonenumber="+phonenumber);
		System.out.println("password="+password);
		UserDAO dao = new UserDAO();
		List<User> users =  dao.findAll();
		System.out.println("size="+users.size());
		for(User user : users){
			String number = user.getPhonenumber();
			String pwd = user.getPassword();
			
			System.out.println("number="+number);
			System.out.println("pwd="+pwd);
			if((phonenumber.equals(number)&&password.equals(pwd))){
				response.sendRedirect("html/Second.html");
			}else{
				request.setAttribute("login_failed","用户名或密码错误");
				request.getRequestDispatcher("/WEB-INF/login_failed.jsp").forward(request, response);
			}
		}
		
	}
}
