package boardtest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import boardmake.MemberDDL;
import boardmake.MembersDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class FindIdPw extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDDL ddl = new MemberDDL();
		int opt = Integer.parseInt(request.getParameter("opt"));
		String val1 = null, val2 = null, rs1 = null, rs2 = null, serviceTalk = null;

		if (opt == 1) {
			val1 = request.getParameter("username");

		} else {
			val1 = request.getParameter("userid");
		}
		val2 = request.getParameter("useremail");

		Vector data = ddl.getSelect(val1, val2, opt);
		int size = data.size();
		for (int i = 0; i < size; i++) {
			MembersDTO dt = (MembersDTO) data.elementAt(i);
			rs1 = dt.getUserid();
			rs2 = dt.getUserpass();
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		out.println("<html><head><title>아이디/패스워드검색</title>");
		out.println(
				"<link rel=\"stylesheet\" href=\"css/bootstrap.css\" /></head><body><div class=\"container text-center\">");
		if (size == 0) {
			out.println("<div class=\"text-danger\">아이디를 찾을수 없습니다</div>");
			out.println("<a href=\"/boardmake/member/findIdPw.jsp\">다시시도</a>");
			out.println("<a href=\"javascript:void(0)\" onclick=\"javascript:self.close();\">닫기</a>");

		} else {
			if (opt == 1) {
				out.println("<p>고객님의 아이디는 ");
				out.println(rs1);
				out.println("입니다.");
				out.println("<a href=\"javascript:void(0)\" onclick=\"opener.document.getElementById('userid').value='"
						+ rs1 + "'\">");
				out.println("아이디사용</a></p>");

			} else {
				out.println("<p>고객님의 비밀번호는 ");
				out.println(rs2);
				out.println("입니다.");
				out.println(
						"<a href=\"javascript:void(0)\" onclick=\"opener.document.getElementById('userpass').value='"
						+ rs1 + "'\">");
				out.println("비밀번호사용</a></p>");

			}
		}
			out.println("</body></html>");
		}
		
	}

