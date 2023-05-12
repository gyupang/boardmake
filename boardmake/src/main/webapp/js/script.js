function findIdPw(){
	const url = "/boardmake/member/findIdPw.jsp";
	const width=500, height=350;
	let left = (document.body.offsetWidth / 2) - (width / 2);
	let top = (document.body.offsetHeight / 2) - (height / 2);
	left += window.screenLeft;
	
	window.open(
		url, 
		"popup", 
		`width=${width}, 
		 height=${height}, 
		 left=${left}, 
		 top=${top}`
    );
}

function memLevel(e,i,num){
	const val = e.value;
	const mems = ["탈퇴회원", "일반회원", "유료회원","VIP회원"];
	let y =confirm("회원정보를 "+mems[val]+"으로 수정하시겠습니까?");
	
		if(y){
			// 회원 정보 수정
			let rs = fetch("/boardmake/LevelUpdate", {
				level : val,
				num: num
				}).then(res=>{
				Response.text()).then(res=>
				
				)
			}))
			
		}else{
		  // 옵션 박스의 값을 원래대로 되돌림
     return false;
    
		}
	}
	
}