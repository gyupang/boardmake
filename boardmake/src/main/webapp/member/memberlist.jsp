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

/* 
1. 전체 페이지 수, 2. 전체 블록수 , 3, 현재 블록번호 , 4. 블록당 시작번호 , 5. 블록당 마지막 번호
 */
 int totalPage = (int) Math.ceil(maxColumn/ (double)listNum);
 int totalBlock = (int) Math.ceil(totalPage/ (double)pageNum);
 int nowBlock = (int) Math.ceil(mypg/(double)pageNum);
 int startNum = (nowBlock -1) * pageNum +1;
 int endNum = nowBlock * pageNum;
 if(endNum>totalPage) endNum = totalPage;

%>

<div class="container lmember">
	<h1 class="mt-3 mb-3 text-center">회원 목록 (관리자 전용)</h1>
	<div class="text-end">
	총 회원 : <%= maxColumn %>명
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
               <th>가입일</th>
               <th>회원등급</th>
            </tr>
         </thead>
         <tbody>
<%
for (int i = 0; i < size; i++) {
	MembersDTO dt = (MembersDTO) data.elementAt(i);
int num = dt.getNum();
String userid = dt.getUserid();
String username = dt.getUsername();
String postcode = dt.getPostcode();
String addr = dt.getAddr();
String detailAddr = dt.getDetailaddr();
String tel = dt.getTel();
String wdate=dt.getWdate();
int level = dt.getLevel();

%>
	
       <tr>
          <td><%=num %></td>
          <td><%=userid %></td>
          <td><%=username %></td>
          <td>[<%=postcode %>] <%=addr %> <%=detailAddr %></td>
          <td><%=tel %></td>
          <td><%=wdate %></td>
          <td>
          <%
          if(level ==99){
        	            %>
          
          
		            <% 
              String selected1="", selected2="", selected3="", selected4="";
              switch(level){
                case 0:
            	  selected1 = "selected";
                break;
                case 1:
            	  selected2 = "selected";
                break;
                case 2:
            	  selected3 = "selected";
                break;
                case 3:
            	  selected4 = "selected";
                break;
                
              }
            %>
		
		
		
		
            <select name="level" class="level" onchange="memLevel(this, <%=level%>);">
               <option value="0" <%=selected1 %>>탈퇴회원</option>
               <option value="1" <%=selected2 %>>일반회원</option>
               <option value="2" <%=selected3 %>>유료회원</option>
               <option value="3" <%=selected4 %>>VIP회원</option>
            </select>    
          </td>
       </tr>
	<%
       }
%>	
		
         </tbody>
      
      </table> 
	</div>
	
	<div class="my-5 row">
	<ul class="pagination justify-content-center">
  
  <%
  //이전 페이지
  if(startNum >1){
	  int prevPage = startNum -1;
	  out.print("<li class=\"page-item\"><a class=\"page-link\" href='/boardmake/index.jsp?fname=member/memberlist&page=" + prevPage +"'>이전</a></li>");

	  	  
  }
  //페이지 출력
  for(int i = startNum; i<=endNum; i++){
	  String act="";
	  if(mypg ==i) act = "active";
	  %>
	  <li class="page-item <%= act %>"><a class="page-link" href="/boardmake/index.jsp?fname=member/memberlist&page=<%=i %>"><%=i %></a> </li>
	  
	  <%
	  	    }
    //다음 페이지
  
  %>
  
  
  <li class="page-item"><a class="page-link" href="#">Next</a></li>
</ul></div>
	
	
	

</div>

