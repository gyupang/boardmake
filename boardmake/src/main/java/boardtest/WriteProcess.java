package boardtest;

import java.io.IOException;
import java.io.PrintWriter;

import boardmake.BoardDDL;
import boardmake.BoardDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class WriteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WriteProcess() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		BoardDDL ddl = new BoardDDL();
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		dto.setTitle(title);
		dto.setContent(content);

		int iResult = ddl.insertWrite(dto);

		if (iResult == 1) {
			response.sendRedirect("notice.jsp");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글쓰기에 실패하였습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		}

		doGet(request, response);
	}

}
