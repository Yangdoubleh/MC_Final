<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%-- 
<c:set var="article"  value="${articleMap.article}"  />
<c:set var="imageFileList"  value="${articleMap.imageFileList}"  />

 --%>
<%
  request.setCharacterEncoding("UTF-8");
%> 

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/my.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
 
   <title>글보기</title>
   <style>
   

body {

background-color: rgba(255,0,0,0.1);
}

   
     #tr_file_upload{
       display:none;
     }
     #tr_btn_modify{
       display:none;
     }
    .search_Btn{
	width:auto;
	height:auto;
	margin:5px;
	background-color: #d39a9d ;
	color: #fff;
	font-size:13px;
	font-weight: bold;
	border-radius:5px;
	border:2px solid #d39a9d;
	display:inline-block;
	cursor:pointer;
	text-decoration:none;
	text-align: center;
	line-height: 2;
}

 .search_Btn:hover {
 background-color:#ff2f51;
 color: #fff;
 }
 
 td{
 font-size:13px;
 font-weight: bold;
 
 }
 
 th{
 
 color: #fff;
	font-size:14px;
	font-weight: bold;
	
 }
 
 
 
   </style>

 
 <script type="text/javascript">
 function backToList(){
 	 location.href="../boardList";
  }

	 function fn_enable(){
		 const NO = $("#articleNo").val();
		 $.post("selectArticleID", {NO}, function(msg){
			 console.log(msg);
			if(msg=="ok") {
				 document.getElementById("i_title").disabled=false;
				 document.getElementById("i_content").disabled=false;
			} else {
				alert(msg);
			}
		 });
	 }
	 
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/board/modArticle.do";
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 
	 }
	 
	 function fn_reply_form(url, parentNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNOInput = document.createElement("input");
	     parentNOInput.setAttribute("type","hidden");
	     parentNOInput.setAttribute("name","parentNO");
	     parentNOInput.setAttribute("value", parentNO);
		 
	     form.appendChild(parentNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {
	             $('#preview').attr('src', e.target.result);
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
	 
 	$(document).ready(function(){
 		$("#updateArticleBtn").click(function(){
 			
 			const title=$("#i_title").val();
 			const content=$("#i_content").val();
 			const NO=$("#articleNo").val();
 			
 			
 			$.post("../updateArticle",{title, content,NO},function(data){
 				alert(data);
 				location.reload();
 			})
 		});
 		$("#deleteBtn").click(function (msg) {		
 			const memberID=$.cookie("memberID");
 			if(memberID==$("#i_ID").val()){
	 			var result = confirm("정말 삭제 하시겠습니까?");
				if(result){
					const NO=$("#articleNo").val();
					$.post("../delete",{NO},function(msg){
						alert(msg);
						location.href="boardList";
					});
				} else{}
 			} else {
 				alert("다른 사람의 게시글은 삭제가 불가능합니다.");
 			}
		});
 	});
 </script>
</head>
<body>

<br><br><br>
<div class="container table-responsiv">
  <form name="frmArticle" method="post"  action="${contextPath}"  enctype="multipart/form-data">
  <table  border=0  align="center" class="table table-condensed">
  <tr>
   <td width=150  align="center" bgcolor='#d39a9d '>
      글번호
   </td>
   <td colspan="3">
    <input type="text" id="articleNo" value="${article.NO}"  disabled />
    
   </td>
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#d39a9d ">
       아이디
   </td>
   <td colspan="3">
    <input type=text value="${article.memberID }" name="writer" id="i_ID" disabled />
   </td>
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#d39a9d ">
      제목 
   </td>
   <td colspan="30">
    <input type=text value="${article.title }"  name="title"  id="i_title" disabled />
   </td>   
  </tr>
  <tr>
    <td width="0" align="center" bgcolor="#d39a9d " >
      내용
   </td>
   <td>
    <textarea rows="15"  cols="80"  name="content"  id="i_content"  disabled />${article.content }</textarea>
   </td>  
   <td width="100" align="center" bgcolor="#d39a9d" >
		      이미지
   </td>
   <td>
   		<c:choose> 
	  		<c:when test="${not empty article.fileName && article.fileName!='null' }">	   	
		      	<input  type= "hidden"   name="originalFileName" value="${article.fileName }" />
		    	<img src="${contextPath}/uploadImg/${article.fileName}" id="preview"  height="277" /><br>
		     	 
		 	</c:when>		 
	 	</c:choose>
	 </td>
  </tr>
   <tr>
	   <td width="150" align="center" bgcolor="#d39a9d ">
	      등록일자
	   </td>
	   <td colspan="3">
	    <input type=text value="<fmt:formatDate value="${article.writeDate}" />" disabled />
	   </td>   
  </tr>
 
 </table>
 </form>
 <!-- <form name="articleForm" method="post"   action="../delete"   enctype="multipart/form-data"> -->
  <tr id="tr_btn">
   <td colspan="4" align="center">
         
         <input type=button value="수정하기" class="btn search_Btn" onClick="fn_enable()">
	   
	   
	    <button type=submit class="btn search_Btn" id="updateArticleBtn">저장</button>
	     
	     
	     <button type=submit id="deleteBtn"  class="btn search_Btn deleteBtn" >삭제</button>
	     
	 	 <input type=button value="뒤로가기"  onClick="backToList()" class="btn search_Btn">
	      </form>
	  </td>
  </tr>
 </table>
<!--  </form> -->
 
 </div>
</body>
</html>
