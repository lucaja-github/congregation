package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//String username = request.getParameter("username").trim();
		String phonenumber = request.getParameter("phonenumber").trim();
		String password = request.getParameter("password").trim();
		String incode = request.getParameter("incode").trim();
		String code = CodeServlet.getCodes();	

		if(phonenumber == "" || phonenumber == null){
			request.setAttribute("error_type","手机号为空");
			request.getRequestDispatcher("/WEB-INF/regist_failed.jsp").forward(request, response);
			return;
		}

		if(password == "" || password == null){
			request.setAttribute("error_type","密码为空");
			request.getRequestDispatcher("/WEB-INF/regist_failed.jsp").forward(request, response);
			return;
		}
		
		if(incode == "" || incode == null){
			request.setAttribute("error_type","验证码为空");
			request.getRequestDispatcher("/WEB-INF/regist_failed.jsp").forward(request, response);
			return;
		}

		if(!code.equals(incode)){
			request.setAttribute("error_type","验证码不对");
			request.getRequestDispatcher("/WEB-INF/regist_failed.jsp").forward(request, response);
			return;
		}

		//response.sendRedirect("congregation/login.html");
		UserDAO dao = new UserDAO();		
		List<User> users = dao.findAll();
		boolean reg = true;
		for(User user : users){
			String number = user.getPhonenumber();
			if(phonenumber.equals(number)){
				reg = false;
				break;
			}				
		}
		if(reg){
			dao.save(phonenumber,password);
			request.getRequestDispatcher("/WEB-INF/regist_successful.jsp").forward(request, response);
		}else{
			request.setAttribute("error_type","该用户已存在");
			request.getRequestDispatcher("/WEB-INF/regist_failed.jsp").forward(request, response);
		}
	}

	public static void main(String[] args) {
		String phonenumber ="";
		if(phonenumber == ""){
			System.out.println(90);
			return;
		}
		System.out.println("sahkjals");
	}

}
