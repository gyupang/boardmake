package boardtest;

import java.io.IOException;
import java.io.PrintWriter;

import boardmake.BoardDDL;
import boardmake.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EditProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditProcess() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정 내용 얻기
		int num = Integer.parseInt(request.getParameter("num"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDTO dto = new BoardDTO();
		BoardDDL ddl = new BoardDDL();

		dto.setNum(num);
		dto.setTitle(title);
		dto.setContent(content);

		int affected = ddl.updateEdit(dto);

		// 성공/실패 처리
		if (affected == 1) {
			// 성공 시 상세 보기 페이지로 이동
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정되었습니다.');");
			out.println("location.href='index.jsp?fname=member/view&num=" + dto.getNum() + "';");
			out.println("</script>");

		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정에 실패하였습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		}
	}
}
