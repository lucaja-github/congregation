package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MerchantDao;
import entity.AddressPoint;

/**
 * Servlet implementation class MerchantAddress
 */
public class MerchantAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取页面输入信息
		String merchantName = request.getParameter("merchantName");
		System.out.println("merchantName:"+merchantName);
		
		//从数据库读取
		MerchantDao mDao = new MerchantDao();
		AddressPoint ap = mDao.getMerchantIdByName(merchantName);
		System.out.println("ap:"+ap);
		
		//判断处理
		if(ap!=null) {
				request.setAttribute("addP", ap);
				request.getRequestDispatcher("displayAddress.jsp").forward(request, response);
				return;
		}else {
			response.sendRedirect("error.jsp");
		}
		
	}

}
