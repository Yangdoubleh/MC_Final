$(document).ready(function() {

	const id=$.cookie("id");
	
	$("#memberInsertBtn").click(function() {
		const id = $("#id").val();
		const pw = $("#pw").val();
		const email = $("#email").val();
		const nickname = $("#nickname").val();
		const age = $("#age").val();
		
		//alert(id+":"+pw);
		
		$.post("../memberInsert", { id, pw, email, nickname, age }, function(data) {
			alert(data);
			location.href="index.html";
		});	
	});
	
	
	$("#loginBtn").click(function() {
		const id = $("#id").val();
		const pw = $("#pw").val();
		
		 if(id =='') {
            alert("아이디를 입력하세요");
            $("#id").focus();
            return false;
        } 
        
        if(pw =='') {
            alert("비밀번호를 입력하세요");
            $("#pw").focus();
            return false;
        } 
        
		$.post("login",{id,pw},function(data){
			console.log(data);
			if(data!="fail"){
				const id=data;
				$.cookie("id",id);
				//로그인 성공하면 메인페이지로, 실패하면 이 화면에서 그대로
				location.href="main.html";
			} 
		});
	});
	
	
});
