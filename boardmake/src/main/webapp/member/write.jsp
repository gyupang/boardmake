<%@page import="boardmake.MemberDDL"%>
<%@page import="boardmake.MembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="mem" class="boardmake.MemberDDL" scope="page" />
<jsp:useBean id="dto" class="boardmake.MembersDTO" scope="page" />

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
    
   <%--  <%
    dto.setUserid(request.getParameter("userid"));
    String userId = (String) session.getAttribute("userid");
    if (userId == null) {
    %>
              alert("로그인 후 이용해주십시오.");
          return false;
    <%
    } 
    %>
        } --%>
        
</script>



<div class="container">
	<h1 class="mt-3 mb-3 text-center">글쓰기</h1>

	<form action="WriteProcess" method="post"
		onsubmit="return validateForm(this);">

		<table class="table">
			<tr>
				<td>
					<div class="input-group mb-3">
						<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
						<input type="text" name="title" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-floating">
						<textarea class="form-control" name="content"
							placeholder="Leave a comment here" id="floatingTextarea2"
							style="height: 200px"></textarea>
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
						<input type="hidden" name="userid" value="<%= session.getAttribute("user") %>">


		</table>

	</form>
</div>

