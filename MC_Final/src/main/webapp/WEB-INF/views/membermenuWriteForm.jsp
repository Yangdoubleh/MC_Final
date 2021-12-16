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
<title>식단 입력창</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
  
<script type="text/javascript">
 
  function backToList(){
	  location.href="../membermenuList";
  }
  
$(document).ready(function(){
	const membermenu_memberID=$.cookie('membermenu_memberID');
	if(membermenu_memberID){
		$("#memberID").val(membermenu_memberID);
	}else{
		alert("로그인 먼저 하세요");
		window.close();
	}
});

</script>
 <title>식단 입력창</title>
</head>
<body>
<div class="container">
<h3 style="text-align:center">식단입력</h3>
 <form name="articleForm" method="post"   action="../membermenuWrite"   enctype="multipart/form-data">
	<table class="table table-border">
 	<tr>
		<td > 작성자 : </td>
		<td colspan=2  ><input type="text" size="50" maxlength="100"  id="memberID" name="memberID" 
			readonly style="background:lightgray" /> </td>
	</tr>
	<tr>
		<td > 음식이름 : </td>
		<td colspan="2"><input type="text" size="50"  maxlength="300" id="foodName" name="foodName" /></td>
	</tr>
	<tr>
		<td > 식단한 일자 : </td>
		<td colspan="2"><input type="date" size="50"  maxlength="300" id="foodDate" name="foodDate" /></td>
	</tr>
	<tr>
		<td > </td>
		<td colspan="2" >
			<input type="submit" value="식단 저장하기" class="btn btn-info"/>
			<input type=button value="식단으로" onClick="backToList()" class="btn btn-warning"/>
		</td>
	</tr>
	</table>
 </form>
</div>
</body>
</html>