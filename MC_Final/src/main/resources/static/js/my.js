<<<<<<< HEAD
$(document).ready(function(){
	
	const memberID=$.cookie("memberID");
	if(memberID){
		$("#loginDiv").html(memberID+" login ok <button id='logoutBtn'>logout</button>");
	}
	
	//로그인
	$("#loginBtn").click(function(){
		const memberID=$("#memberID").val();
		const password=$("#password").val();
		
		//alert(memberID+":"+password);
		
		$.post('../login',{memberID,password},function(data){
			data=JSON.parse(data);
			if(data.memberID){
				$("#loginDiv").html(data.memberID+" login ok <button id='logoutBtn'>logout</button>");
				$.cookie("memberID",data.memberID);
			}
			
		});
	});
	
	//로그아웃
	$(document).on("click", "#logoutBtn", function(){
		$.post('../logout',{},function(data){
			data=JSON.parse(data);
			if(data.msg=="ok"){
				$.removeCookie("memberID");
				$.removeCookie("membermenu_memberID",{path:'/'});
				location.reload();
			}else{
				alert(data.msg);
			}
		});
	});

});

//장바구니
function insertBasket(foodName){
	const memberID=$.cookie("memberID");
	if(memberID){
		alert(foodName+"를(을) 장바구니에 넣겠습니까?");
		$.post('insertBasket',{foodName},function(data){
			alert(data);
		});
	}else{
		alert("로그인부터 하세요");
	}
}
=======
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
>>>>>>> master
