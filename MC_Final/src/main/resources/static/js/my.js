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