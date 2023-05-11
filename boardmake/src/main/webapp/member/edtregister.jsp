<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="boardmake.MembersDTO"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mem" class="boardmake.MemberDDL" scope="page" />
<jsp:useBean id="dto" class="boardmake.MembersDTO" scope="page" />

<%
String str = null;
String user =  (String)session.getAttribute("user");

Vector data =mem.getSelect(user);
int size = data.size();
for(int i=0; i < size; i++){
    MembersDTO dt = (MembersDTO) data.elementAt(i);
    pageContext.setAttribute("dto", dt);
 }


%>


 <div id="logreg-forms">
 <form action="/boardmake/MemUpdate" class="form-signup" method="post" name="edtregisterform">
 <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign Up</h1>
<!--                 <div class="social-login">
                    <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign up with Facebook</span> </button>
              
                    <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign up with Google+</span> </button>
                </div> -->

<div class="form-group">
    <label for="userid">User ID:</label><br>
    <input type="text" class="form-control" id="userid" name="userid" value="${dto.userid}" readonly="readonly">
    <input type="button" class="btn btn-primary" value="중복 확인">
  </div>
  <div class="form-group">
    <label for="userpass">Password:</label>
    <input type="password" class="form-control" id="userpass" name="userpass" required>
  </div>
  <div class="form-group">
    <label for="username">Name:</label>
    <input type="text" class="form-control" id="username" name="username" value="${dto.username}">
  </div>
  <div class="form-group">
    <label for="useremail">Email:</label>
    <input type="email" class="form-control" id="useremail" name="useremail" value="${dto.useremail}">
  </div>
  <div class="form-group">
    <label for="postcode">Postcode:</label><br>
    <input type="text" class="form-control" id="postcode" name="postcode">
 <input type="button" class="btn btn-primary" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
  </div>
  <div class="form-group">
    <label for="addr">Address:</label>
    <input type="text" class="form-control" id="addr" name="addr"  value="${dto.addr}">
  </div>
  <div class="form-group">
    <label for="detailaddr">Detail Address:</label>
    <input type="text" class="form-control" id="detailaddr" name="detailaddr" value="${dto.detailaddr}">
  </div>
    <div class="form-group">
    <label for="extraaddr">Extra Address:</label>
    <input type="text" class="form-control" id="extraaddr" name="extraaddr" >
  </div>
  <div class="form-group">
    <label for="tel">Phone:</label>
    <input type="text" class="form-control" id="tel" name="tel" placeholder="01000000000" value="${dto.tel}">
  </div>

<input type="hidden"  name="useridok" id="useridok" />


                <button  type="button" class="btn btn-success btn-block" onclick="register2();"><i class="fas fa-user-plus"></i> Sign Up</button>
                <a href="index.jsp" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            </div>
 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        <script src="js/form.js"></script>
