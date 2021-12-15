$(document).ready(function(){
	const id=$.cookie("id");
	if(id){
		$("#loginDiv").html(id+" <button id='logoutBtn'>logout</button>");
	}
	
	$(document).on('click','#logoutBtn',function(){
		$.post('logout',{},function(){			
				$.removeCookie("id");		
				location.reload();			
		});		
	});
	
	
	$("#loginBtn").click(function(){
		const id=$("#id").val();
		const pw=$("#pw").val();
		$.post('login',{id,pw},function(data){
			data=JSON.parse(data);
			if(data.id){
				$.cookie("id",id);
				$("#loginDiv").html(data.id+" <button id='logoutBtn'>logout</button>");
			}else{
				alert("id와 pw 확인해주세요");
			}
		});
	});
	
});