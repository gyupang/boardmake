<%@page import="boardmake.BoardDDL"%>
<%@page import="boardmake.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="bdr" class="boardmake.BoardDDL" scope="page" />
<jsp:useBean id="bdto" class="boardmake.BoardDTO" scope="page" />
<%
String num = request.getParameter("num");  // 일련번호 받기 

bdr.selectView(num)             ;   // 조회수 증가 
BoardDTO dto = bdr.selectView(num) ;       // 게시물 가져오기 
%>

<div class="container">
<p>num 값: <%= num %></p>
        	<h1 class="mt-3 mb-3 text-center">게시판</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
                <tbody>

                <tr>
                    <td><%= dto.getNum() %></td>
                    <td><%= dto.getTitle() %></td>
                    <td><%= dto.getContent() %></td>
                    <td><%= dto.getUserid()%></td>
                    <td><%= dto.getWdate().toLocalDate() %></td>
                    <td><%= dto.getCount()%></td>
                </tr>

        </tbody>
        </table>
        
<button type="button" class="btn btn-outline-primary" onclick="history.back();">뒤로 가기</button>

    </div>

