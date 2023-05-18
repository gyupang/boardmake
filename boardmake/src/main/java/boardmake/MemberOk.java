package boardmake;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberOk extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();

		// DAO 객체를 생성하여 DTO 객체를 데이터베이스에 저장
		MemberDDL ddl = new MemberDDL();

		String ip = request.getRemoteAddr();

		// HttpServletRequest 객체를 통해 클라이언트의 요청 파라미터를 가져오기
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		String username = request.getParameter("username");
		String useremail = request.getParameter("useremail");
		String postcode = request.getParameter("postcode");
		String addr = request.getParameter("addr");
		String detailaddr = request.getParameter("detailaddr");
		String tel = request.getParameter("tel");
		String uip = request.getRemoteAddr();

		// 클라이언트의 요청 파라미터를 DTO 객체에 저장
		dto.setUserid(userid);
		dto.setUserpass(userpass);
		dto.setUsername(username);
		dto.setUseremail(useremail);
		dto.setPostcode(postcode);
		dto.setAddr(addr);
		dto.setDetailaddr(detailaddr);
		dto.setTel(tel);
		dto.setUip();

		boolean isSuccess = ddl.insert(dto);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String script = null;
		if (isSuccess) {
			script = "<script>alert('가입했습니다.');" + "document.location.href='/boardmake';" + "</script>";
		} else {
			script = "<script>alert('문제가 발생했습니다. \n 관리자에게 문의해주세요.');" + "document.location.href='/boardmake';"
					+ "</script>";
		}
		out.println("<html><head></head><body>");
		out.println(script);
		out.println("</body></html>");

		doGet(request, response);
	}

}
