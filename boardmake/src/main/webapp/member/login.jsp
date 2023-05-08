<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
String message =null;

%>
<%

message = (String)request.getAttribute("message");
if(message !=null){
	%>
	
	<script>
	alert("<%=message %>");
	
	</script>
		
	<%
}
%>

 <div id="logreg-forms">
        <form class="form-signin" name="loginform" action="/boardmake/MemberLogin" method="post">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
            <div class="social-login">
                <button class="btn facebook-btn social-btn" type="button"><span><i class="fa-solid fa-k"></i> Sign in with Kakao</span> </button>
                <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span> </button>
            </div>

            <input type="text" id="userid" name="userid" class="form-control" placeholder="ID" required="" autofocus="" >
            <label><input type="checkbox" name="huid" value="ok"  onclick="isChecked();"> 아이디 기억</label>
            <input type="password" id="userpass" name="userpass" class="form-control" placeholder="Password" required="">
            
            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt" onclick="loginSubmit();"></i> Sign in</button>
            <a href="#" id="forgot_pswd">Forgot password?</a>
            <hr>
            <!-- <p>Don't have an account!</p>  -->
            <a href="?fname=register"><button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button></a>
            </form>

<!--             <form action="/reset/password/" class="form-reset">
                <input type="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                <button class="btn btn-primary btn-block" type="submit">Reset Password</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
            </form> -->


    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src= "js/key.js"></script>
    <script src= "js/form.js"></script>
