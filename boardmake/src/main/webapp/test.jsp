<%@page import="java.util.Vector"%>
<%@page import="boardmake.MembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="mem" class="boardmake.MemberDDL" scope="page" />
<jsp:useBean id="dto" class="boardmake.MembersDTO" scope="page" />
    <%!
   String username = null;
%>

<%
   
   Vector data = mem.getSelect("admin");
   int size = data.size();
   for(int i = 0; i < size; i++) {
	   MembersDTO m = (MembersDTO) data.elementAt(i);
	   String username = m.getUsername();
   }
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=username %>
</body>
</html>