package boardtest;

import java.io.IOException;
import java.io.PrintWriter;

import boardmake.BoardDDL;
import boardmake.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class DeleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));

		BoardDTO dto = new BoardDTO();
		BoardDDL ddl = new BoardDDL();

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user");
		int delResult = 0;

		if (userId.equals(dto.getUserid())) { 
			  // 작성자가 본인이면...
		dto.setNum(num);
		delResult = ddl.deletePost(dto);
		
		// 성공/실패 처리
		if (delResult == 1) {
			// 성공 시 상세 보기 페이지로 이동
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다.');");
			out.println("history.go(-2);");
			out.println("</script>");

		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제에 실패하였습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('본인만 삭제할 수 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
	}
}
}
