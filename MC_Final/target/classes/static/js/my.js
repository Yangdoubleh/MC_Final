$(document).ready(function() {

	const id=$.cookie("id");
	if(id){
		$("#idSpan").html(id+"님 <br> 환영합니다!");
		$("#myId").html(id);
	}
	
	
	
	$("#memberInsertBtn").click(function() {
		const id = $("#id").val();
		const pw = $("#pw").val();
		const email = $("#email").val();
		const nickname = $("#nickname").val();
		const age = $("#age").val();

		//alert(id+":"+pw);
		
		$.post("../memberInsert", { id, pw, email, nickname, age }, function(data) {
			alert(data);
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
        
		$.post('../login', { id, pw }, function(data) {
			data = JSON.parse(data);
			if (data.id) {
				location.href="main.html";
				$("#idSpan").html(id+"님 <br> 환영합니다!");
				$.cookie("id", data.id);
			} else{
				alert("아이디 또는 비밀번호를 다시 확인해주세요.");
			}
		});
	});
	
	$("#logoutBtn").click(function() {
		$.post('../logout', {}, function(data) {
			data = JSON.parse(data);
			if (data.msg == "ok") {
				$.removeCookie("id");
				location.href="index.html";
			} else {
				alert(data.msg);
			}
		});
	})
	
});
