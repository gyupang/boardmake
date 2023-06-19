//정규식


const uidpw = /^[a-zA-Z0-9]{3,8}$/;   // 아이디가 영문과 숫자로만 이루어지고, 4자리 이상 8자 이하인 정규식

const uname = /^[a-zA-Z가-힣]{2,15}$/  //한글과 영문 대소문자를 모두 허용하고, 2자리에서 15자리 사이의 문자열

const uemail = /^([a-zA-Z0-9]+[_-]?)*[a-zA-Z0-9]+@[a-zA-Z0-9]+([-_.]?[a-zA-Z0-9]+)*\.[a-zA-Z]{2,4}$/

const utel = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/


window.onload = function(){
	if(getCookie("user")) {
		document.getElementById("userid").value=getCookie("user");
		document.loginform.huid.checked = true;
	}
}

    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraaddr").value = extraAddr;
                
                } else {
                    document.getElementById("extraaddr").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("addr").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailaddr").focus();
            }
        }).open();
    }


function register() {
	//변수 정의
	const userid = document.getElementById("userid");
	const userpass = document.getElementById("userpass");
	const username = document.getElementById("username");
	const useremail = document.getElementById("useremail");
	const postcode = document.getElementById("postcode");
	const addr = document.getElementById("addr");
	const detailaddr = document.getElementById("detailaddr");
	const tel = document.getElementById("tel");
	/*const tel2 = document.getElementById("tel2");
	const tel3 = document.getElementById("tel3");
	const tel = tel1 + " - " + tel2 + " - " + tel3 ;*/
	const useridok = document.getElementById("useridok");

	if (userid.value == "") {
		alert("아이디를 입력하세요")
		userid.focus();
		return false;

	} else if (!uidpw.test(userid.value)) {
		alert("아이디는 4-8자입니다")
		userid.value = "";
		userid.focus();
		return false;

   /*
   else if(useridok.value==""){
      alert("아이디 중복 확인을 하세요.");
      userid.focus();
      return false;
   }
   */


	} else if (!uidpw.test(userpass.value)) {
		alert("비밀번호는 4- 8자리 입니다.");
		userpass.value = "";
		userpass.focus();
		return false;

	} else if (!uname.test(username.value)) {
		alert("이름은 2-15자의 한글과 영문 대소문자만 가능합니다.");
		username.focus();
		return false;

	} else if (!uemail.test(useremail.value)) {
		alert("이메일 형식이 올바르지 않습니다.");
		useremail.focus();
		return false;

	} else if (postcode.value == "") {
		alert("우편번호를 입력해주세요.");
		postcode.focus();
		return false;
	}

	else if (addr.value == "") {
		alert("주소를 입력해주세요.");
		addr.focus();
		return false;


	} else if (!utel.test(tel.value)) {
		alert("전화번호 양식을 맞춰주세요.");
		tel.focus();
		return false;
	}
//	document.getElementById("tel").value=tel;
//이상없을 경우 submit
document.registerform.submit();
}

function loginSubmit(){
	const form = document.loginform;
    const is_checked = form.huid.checked;
    
	if(form.userid.value==""){
		alert("아이디를 입력하세요.");
		form.userid.focus();
		return false;
	}else if(form.userpass.value==""){
		alert("비밀번호를 입력하세요.");
		form.userpass.focus();
		return false;
	}
	if(is_checked){ //체크박스에 체크 되어 있으면 쿠키를 굽는다. 맛있게!!!
	    setCookie('user', form.userid.value, '3');		
	}else{
		//체크가 되어 있지 않다면 쿠키를 삭제한다.
		delCookie('user');
	}
	
	form.submit();
}


function register2() {
	//변수 정의
	const userid = document.getElementById("userid");
	const userpass = document.getElementById("userpass");
	const username = document.getElementById("username");
	const useremail = document.getElementById("useremail");
	const postcode = document.getElementById("postcode");
	const addr = document.getElementById("addr");
	const detailaddr = document.getElementById("detailaddr");
	const tel = document.getElementById("tel");
	/*const tel2 = document.getElementById("tel2");
	const tel3 = document.getElementById("tel3");
	const tel = tel1 + " - " + tel2 + " - " + tel3 ;*/
	const useridok = document.getElementById("useridok");

	if (userid.value == "") {
		alert("아이디를 입력하세요")
		userid.focus();
		return false;

	} else if (!uidpw.test(userid.value)) {
		alert("아이디는 4-8자입니다")
		userid.value = "";
		userid.focus();
		return false;

   /*
   else if(useridok.value==""){
      alert("아이디 중복 확인을 하세요.");
      userid.focus();
      return false;
   }
 
*/


	} else if (userpass.value != "" && !uidpw.test(userpass.value)) {
		alert("비밀번호는 4- 8자리 입니다.");
		userpass.value = "";
		userpass.focus();
		return false;
		
	} else if (!uname.test(username.value)) {
		alert("이름은 2-15자의 한글과 영문 대소문자만 가능합니다.");
		username.focus();
		return false;

	} else if (!uemail.test(useremail.value)) {
		alert("이메일 형식이 올바르지 않습니다.");
		useremail.focus();
		return false;

	} else if (postcode.value == "") {
		alert("우편번호를 입력해주세요.");
		postcode.focus();
		return false;
	}

	else if (addr.value == "") {
		alert("주소를 입력해주세요.");
		addr.focus();
		return false;


	} else if (!utel.test(tel.value)) {
		alert("전화번호 양식을 맞춰주세요.");
		tel.focus();
		return false;
	}
//	document.getElementById("tel").value=tel;
//이상없을 경우 submit
document.edtregisterform.submit();
}

function loginSubmit(){
	const form = document.loginform;
    const is_checked = form.huid.checked;
    
	if(form.userid.value==""){
		alert("아이디를 입력하세요.");
		form.userid.focus();
		return false;
	}else if(form.userpass.value==""){
		alert("비밀번호를 입력하세요.");
		form.userpass.focus();
		return false;
	}
	if(is_checked){ //체크박스에 체크 되어 있으면 쿠키
	    setCookie('user', form.userid.value, '3');		
	}else{
		//체크가 되어 있지 않다면 쿠키를 삭제한다.
		delCookie('user');
	}
	
	form.submit();
}

function isChecked(){
   const chk = document.loginform.huid;
   const is_checked = chk.checked;
   
   if(is_checked) {
	  let y = confirm("아이디를 저장하시겠습니다. \n 공공장소에서는 추천하지 않습니다.");
	  if(y==false){
		  chk.checked = false;
	 }
	}
}