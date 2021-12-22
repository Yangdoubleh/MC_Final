$(document).ready(function() {

	const memberID=$.cookie("memberID");
	if(memberID){
		$("#idSpan").html(memberID+"님 <br> 환영합니다!");
		$("#myId").html(memberID);
	}
	
	
	
	$("#memberInsertBtn").click(function() {
		const memberID = $("#memberID").val();
		const password = $("#password").val();
		const email = $("#email").val();
		const nickname = $("#nickname").val();
		const age = $("#age").val();

		//alert(id+":"+pw);
		
		$.post("../memberInsert", { memberID, password, email, nickname, age }, function(data) {
			alert(data);
		});	
	});
	
	$("#loginBtn").click(function() {
		const memberID = $("#memberID").val();
		const password = $("#password").val();
		
		
		 if(memberID =='') {
            alert("아이디를 입력하세요");
            $("#memberID").focus();
            return false;
        } 
        
        if(password =='') {
            alert("비밀번호를 입력하세요");
            $("#password").focus();
            return false;
        } 
        
		$.post('../login', { memberID, password }, function(data) {
			data = JSON.parse(data);
			if (data.memberID) {
				location.href="main.html";
				$("#idSpan").html(memberID+"님 <br> 환영합니다!");
				$.cookie("memberID", data.memberID);
			} else{
				alert("아이디 또는 비밀번호를 다시 확인해주세요.");
			}
		});
	});
	
	$("#logoutBtn").click(function() {
		$.post('../logout', {}, function(data) {
			data = JSON.parse(data);
			if (data.msg == "ok") {
				$.removeCookie("memberID");
			} else {
				alert(data.msg);
			}
		});
	})
	
});
