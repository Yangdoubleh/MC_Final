<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<%
  request.setCharacterEncoding("UTF-8");
%> 

<head>
<meta charset="UTF-8">
<title>글쓰기창</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
  
<script type="text/javascript">
 
  function backToList(){
	  location.href="../boardList";
  }
  
$(document).ready(function(){
	const board_id=$.cookie('board_id');
	if(board_id){
		$("#id").val(board_id);		
	}else{
		//alert("로그인 먼저 하세요");
		window.close();
	}
	
	
});

</script>
<style>
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
 }
 
 
body {

background-color: rgba(255,0,0,0.1);
}
 
   </style>
 <title>글쓰기창</title>
</head>
<body>
<div class="container">
<h3 style="text-align:center">글쓰기</h3>
  <form name="articleForm" method="post"   action="../boardWrite"   enctype="multipart/form-data">
    <table class="table table-border">
      <tr>
					<td > 작성자 : </td>
					<td colspan=2  ><input type="text" size="50" maxlength="100"  name="memberID" value="aaa"
					readonly style="background:lightgray" /> </td>
			</tr>
	     <tr>
			   <td >글제목 : </td>
			   <td colspan="2"><input type="text" size="50"  maxlength="300" name="title" /></td>
		 </tr>
	 		<tr>
				<td valign="top"><br>글내용 : </td>
				<td colspan=2><textarea name="content" rows="10" cols="53" maxlength="4000" id="cont"></textarea> </td>
     </tr>
     <tr>
			  <td >파일 첨부 :  </td>
			  <td> <input type="file" name="file"  /></td>

	
				
				
	   </tr>
	   <tr>
	      <td colspan="4"><div id="d_file"></div></td>
	   </tr>
	    <tr>
	      <td > </td>
	      <td colspan="2" >
	       <input type="submit" id="submitBtn" value="글쓰기" class="btn search_Btn"/>
	       <input type=button value="목록보기" onClick="backToList()" class="btn search_Btn"/>
	      </td>
     </tr>
    </table>
  </form>
  </div>
</body>
</html>
