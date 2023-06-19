<%@page import="boardmake.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bdr" class="boardmake.BoardDDL" scope="page" />
<jsp:useBean id="bdto" class="boardmake.BoardDTO" scope="page" />
<%
String num = request.getParameter("num"); // 일련번호 받기 

bdr.updateVisitCount(num); // 조회수 증가 
BoardDTO dto = bdr.selectView(num); // 게시물 가져오기
%>


<div class="container-sm">
	<h1 class="mt-3 mb-3 text-center">게시판</h1>
	<table class="table">
		<thead>
			<tr>
				<th class="col-1">No.</th>
				<th class="col-5">제목</th>
				<!-- <th>내용</th> -->
				<th class="col-2">작성자</th>
				<th class="col-2">작성일</th>
				<th class="col-2">조회수</th>
			</tr>
		</thead>
		<tbody>

			<tr>
				<td><%=dto.getNum()%></td>
				<td><%=dto.getTitle()%></td>

				<td><%=dto.getUserid()%></td>
				<td><%=dto.getWdate().toLocalDate()%></td>
				<td><%=dto.getCount()%></td>
			</tr>
			<tr>
			
			  <td colspan="10">
        <div class="mt-1 mb-1 text-center font-weight-bold">내용</div>

    </td>
				
			</tr>
			<tr>
			<td class="col-2"></td>
				<td colspan="8">
				<div class="mt-4 mb-4"><%=dto.getContent().replace("\n", "<br>")%></div>
				
				
				</td>
				<td class="col-2"></td>
			</tr>

		</tbody>
	</table>

	<div class="text-end">

<button type="button" class="btn btn-outline-success" onclick="location.href='?fname=member/edit&num=<%= num %>'">수정 하기</button>
<!-- 삭제하기 버튼을 폼으로 감싸기 -->
<form action="DeleteProcess" method="POST"  class="d-inline">
  <input type="hidden" name="num" value="<%= num %>">
  <button type="submit" class="btn btn-outline-danger">삭제하기</button>
</form>
		<button type="button" class="btn btn-outline-primary " onclick="history.back();">뒤로 가기</button>
	</div>
</div>

