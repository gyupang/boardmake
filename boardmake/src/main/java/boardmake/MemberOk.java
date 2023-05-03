package boardmake;

import java.io.IOException;

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
		dto.setPostcode("0");
		dto.setAddr(addr);
		dto.setDetailaddr(detailaddr);
		dto.setTel(tel);
		dto.setUip();

		boolean isSuccess = ddl.insert(dto);
		if (isSuccess) {
			System.out.println("인서트 성공");
		} else {
			System.out.println("인서트 실패");
		}

		doGet(request, response);
	}

}
