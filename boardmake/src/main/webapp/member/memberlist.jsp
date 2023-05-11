<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="boardmake.MembersDTO"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="mem" class="boardmake.MemberDDL" scope="page" />
<jsp:useBean id="dto" class="boardmake.MembersDTO" scope="page" />

<%!int listNum = 10; //한페이지당 보여줄 목록 수
	int pageNum = 15; //한페이지당 보여줄 페이지 수%>

<%
String pg = request.getParameter("page");
int mypg = 1;
try {
	mypg = Integer.parseInt(pg);
	if (mypg < 1)
		mypg = 1;
} catch (Exception e) {
	mypg = 1;
}
int limitNum = (mypg - 1) * listNum;

Vector data = mem.getSelect(limitNum, listNum);
int maxColumn = mem.getAllSelect();
int size = data.size();


%>

<div class="container lmember">
	<h1 class="mt-3 mb-3 text-center">회원 목록 (관리자 전용)</h1>
	<div class="text-end">
	총 회원 : <%= maxColumn %>
	</div>
	
	
	<div class="row">
		<table class="table table-striped memberstbl">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>주소</th>
					<th>전화번호</th>

				</tr>


			</thead>
<%
for (int i = 0; i < size; i++) {
	MembersDTO dt = (MembersDTO) data.elementAt(i);
int num = dt.getNum();
String userid = dt.getUserid();
String username = dt.getUsername();
String postcade = dt.getPostcode();
String addr = dt.getAddr();
String detailaddr = dt.getDetailaddr();
String useremail = dt.getUseremail();
String tel = dt.getTel();
String wdate=dt.getWdate();
int level = dt.getLevel();
}
%>
	
		<tr>
			<td><%= num %></td>
			<td><%= userid %></td>
			<td><%=username %></td>
			<td><%=postcade %><%= addr %><%=detailaddr %></td>
			<td><%= wdate %></td>
			<td><%= tel %></td>
		</tr>
		
		
		
		<select name = "level" class="level">
		<option value="0" <%=selected1 %>>탈퇴회원</option>
		<option value="1" <%=selected2 %>>일반회원</option>
		<option value="2" <%=selected3 %>>유료회원</option>
		<option value="3" <%=selected4 %>>VIP회원</option>
		<option value="99" <%=selected5 %>>관리자</option>
				</select>
		
		

		</table>
	</div>

</div>

