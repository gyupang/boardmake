<%@page import="boardmake.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bdr" class="boardmake.BoardDDL" scope="page" />
<jsp:useBean id="bdto" class="boardmake.BoardDTO" scope="page" />
<%
String num = request.getParameter("num"); // 일련번호 받기 
BoardDTO dto = bdr.selectView(num); // 게시물 가져오기
String userId = (String) session.getAttribute("user");
if (!userId.equals(dto.getUserid())) {      // 본인인지 확인
%>
<script>
    alert("작성자 본인만 수정할 수 있습니다");
    history.back();
</script>
<%
    return;
}
%>
<script type="text/javascript">
   function validateForm(form) {
	    if (form.title.value == "") {
	        alert("제목을 입력하세요.");
	        form.title.focus();
	        return false;
	    }
	    if (form.content.value == "") {
	        alert("내용을 입력하세요.");
	        form.content.focus();
	        return false;
	    }
	  
	    return true; // 폼의 유효성 검사가 완료되었으므로 true를 반환합니다.
	}
   
        
</script>


<div class="container">
	<h1 class="mt-3 mb-3 text-center">게시판 - 수정하기</h1>

	<form action="EditProcess" method="post"
		onsubmit="return validateForm(this);">

		<table class="table">
			<tr>
				<td>
					<div class="input-group mb-3">
						<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
						<input type="hidden" value="<%=dto.getNum()%>" />
						<input type="text" name="title" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" value="<%=dto.getTitle()%>">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-floating">
						<textarea class="form-control" name="content"
							placeholder="Leave a comment here" id="floatingTextarea2"
							style="height: 200px">
							<%=dto.getContent()%>
							</textarea>
						<label for="floatingTextarea2">내용</label>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-outline-success">작성
						완료</button>
					<button type="reset" class="btn btn-outline-danger">다시 입력</button>
					<button type="button" class="btn btn-outline-primary"
						onclick="location.href='?fname=freeBoard';">목록 보기</button>
				</td>
			</tr>

			<input type="hidden" name="userid" value="<%= userId %>">
			<input type="hidden" name="bbsnum" value="1">
			<input type="hidden" name="uip" value="<%= request.getRemoteAddr() %>">


		</table>

	</form>
</div>

