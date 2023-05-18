<%@page import="boardmake.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="bdr" class="boardmake.BoardDDL" scope="page" />
<jsp:useBean id="bdto" class="boardmake.BoardDTO" scope="page" />

<%
// getSelect 메서드를 호출하여 데이터 가져오기
Vector<BoardDTO> data = bdr.getSelect();    
Collections.reverse(data);
%>
  
    <div class="container">
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
            <% for (BoardDTO board : data) { %>
                <tr>
                    <td><%= board.getNum() %></td>
                    <td><%= board.getTitle() %></td>
                    <td><%= board.getContent() %></td>
                    <td><%= board.getUserid() %></td>
                    <td><%= board.getWdate().toLocalDate() %></td>
                    <td><%= board.getCount() %></td>
                </tr>
            <% } %>
        </tbody>
        </table>
        
        <input type="button" value="글쓰기" onclick="location.href='?fname=member/write'" class="btn btn-secondary btn-sm">
    </div>

