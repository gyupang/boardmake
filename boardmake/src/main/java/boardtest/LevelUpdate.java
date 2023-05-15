package boardtest;

import java.io.IOException;

import boardmake.MemberDDL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LevelUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		MemberDDL ddl = new MemberDDL();
		int level = Integer.parseInt(request.getParameter("level"));
		int num = Integer.parseInt(request.getParameter("num"));

		response.setContentType("text/html;charset=UTF-8");


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
