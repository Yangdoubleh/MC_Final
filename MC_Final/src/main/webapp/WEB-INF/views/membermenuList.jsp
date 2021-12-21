<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
 <style>
   .cls1 {text-decoration:none;}
   .cls2{text-align:center; font-size:30px;}
  </style>
  <meta charset="UTF-8">
  <title>나의 식단</title>
<link href="signup.css" rel="stylesheet">
<script>
	function fn_articleForm(articleForm){
		var memberID=getCookie("memberID");
	  if(memberID){
		  document.cookie="membermenu_memberID="+memberID;
	    location.href=articleForm;
	  }else{
	    alert("로그인 후 식단 저장이 가능합니다.")
	    window.close();
	  }
	}
	function getCookie(cname) {
		  let name = cname + "=";
		  let decodedCookie = decodeURIComponent(window.opener.document.cookie);
		  let ca = decodedCookie.split(';');
		  for(let i = 0; i <ca.length; i++) {
		    let c = ca[i];
		    while (c.charAt(0) == ' ') {
		      c = c.substring(1);
		    }
		    if (c.indexOf(name) == 0) {
		      return c.substring(name.length, c.length);
		    }
		  }
		  return "";
	}
</script>
</head>
<body>
<br>
<h2 align="center">식단 보기</h2>
<br>
<div class="container">
<table align="center" border="0"  width="80%"  class="table table-striped">
  <tr height="10" align="center"  bgcolor="lightgray">
	<td >No</td>
	<td >작성자</td>              
	<td >음식 이름</td>
	<td >식단한 일자</td>
  </tr>
<c:choose>
	<c:when test="${membermenuList == null }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 식단이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
	</c:when>
	<c:when test="${membermenuList !=null }" >
	<c:forEach  var="article" items="${membermenuList }" varStatus="articleNum" >
		<tr align="center">
			<td width="5%">  ${articleNum.count}</td>
			<td width="20%"> ${article.memberID}</td>
			<td width="40%"> ${article.foodName}</td>
			<td width="40%"> ${article.foodDate}</td>
		</tr>
	</c:forEach>
	</c:when>
</c:choose>
</table>
</div>

<center>
	<a href="javascript:fn_articleForm('../membermenuWriteForm')"><p class="btn btn-info">식단 입력</p></a>
</center>
</body>
</html>
