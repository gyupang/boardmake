package boardtest;

import java.io.IOException;

import boardmake.MemberDDL;
import boardmake.MembersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemberLogin extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MembersDTO dto = new MembersDTO();
		MemberDDL db = new MemberDDL();

		String url = null;


		// MemberDTO에 setter로 파라미터 정보를 보낸 후 db에서 getter로 받을수 있도록 함.
		dto.setUserid(request.getParameter("userid"));
		dto.setUserpass(request.getParameter("userpass"));
//MemberDDL 의 매개변수로 MemebersDTO를 받아 getter를 통해 db를 select 해서 조사.
		// 결과를 true false로 출력함
		boolean isSuccess = db.checkLoging(dto);
		if (isSuccess == true) {

//세션등록
			url = "index.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("user", request.getParameter("userid"));
			response.sendRedirect(url);


		} else {
			url = "?fname=login";
			request.setAttribute("message", "아이디 또는 비밀번호가 틀렸습니다.");
			// forward를 통해 실패 변수를 전달 시킨다.
			request.getRequestDispatcher(url).forward(request, response);

		}

		doGet(request, response);

	}

}
