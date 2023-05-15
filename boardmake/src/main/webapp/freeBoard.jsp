<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="boardmake.MembersDTO"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="mem" class="boardmake.BoardDDL" scope="page" />
<jsp:useBean id="dto" class="boardmake.BoardDTO" scope="page" />

    <div class="container">
        	<h1 class="mt-3 mb-3 text-center">게시판</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>박진수</td>
                    <td>First Post</td>
                    <td>This is the content of the first post.</td>
                       <td>0</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>박진수</td>
                    <td>Second Post</td>
                    <td>This is the content of the second post.</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>박진수</td>
                    <td>Third Post</td>
                    <td>This is the content of the third post.</td>
                    <td>0</td>
                </tr>
            </tbody>
        </table>
    </div>
