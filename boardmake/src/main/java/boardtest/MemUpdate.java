package boardtest;

import java.io.IOException;
import java.io.PrintWriter;

import boardmake.MemberDDL;
import boardmake.MembersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class MemUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();
		MemberDDL ddl = new MemberDDL();
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");

		dto.setUserid(request.getParameter("userid"));
		dto.setUserpass(request.getParameter("userpass"));
		dto.setUsername(request.getParameter("username"));
		dto.setUseremail(request.getParameter("useremail"));
		dto.setPostcode(request.getParameter("postcode"));
		dto.setAddr(request.getParameter("addr"));
		dto.setDetailaddr(request.getParameter("detailaddr"));
		dto.setTel(request.getParameter("tel"));
		dto.setUip();
		dto.setWdate();
		boolean isSuccess = ddl.update(dto, user);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String script = null;
		if (isSuccess) {
			script = "<script>alert('수정했습니다.');" + "document.location.href='/boardmake';" + "</script>";
		} else {
			script = "<script>alert('문제가 발생했습니다. \n 관리자에게 문의해봤자 관리자가 뭘알겠습니까.');"
					+ "document.location.href='/boardmake';"
					+ "</script>";
		}
		out.println("<html><head></head><body>");
		out.println(script);
		out.println("</body></html>");

		doGet(request, response);
	}

}
