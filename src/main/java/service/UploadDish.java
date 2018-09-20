package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import io.web.LoadFile;

/**
 * Servlet implementation class UploadDish
 */
public class UploadDish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> paths = new ArrayList<String>();
		LoadFile lf = new LoadFile();
		lf.setUrl("E:\\workspace\\congregation\\src\\main\\webapp\\images\\dish\\");
		lf.setExt(".jpg");
		paths.addAll(lf.run(request, response));
	}

}
