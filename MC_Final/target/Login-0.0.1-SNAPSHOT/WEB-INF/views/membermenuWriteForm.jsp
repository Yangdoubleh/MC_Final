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
  <script type="text/javascript" src="js/my.js"></script>
<link href="signup.css" rel="stylesheet">
<script type="text/javascript">
   $(document).ready(function(){
      const memberID=$.cookie("memberID");
      $("#memberID").val(memberID);
   });
</script>

 <title>식단 입력</title>
</head>

<style>

.write-Form {
  position:absolute;
  max-width: 70%;
  width:100%;
  background-color:#FFFFFF;
  text-align:center;
  top:50%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}

.textForm2{
  border-bottom: 2px solid #adadad;
  margin: 20px 50px 20px 50px;
  padding: 15px 0px 15px 0px;
}

</style>
<body>
<div class="container">
 <form method="post" action="membermenuWrite"   enctype="multipart/form-data" class="write-Form">
   <div>                  
      <h2><i class="bi bi-journal-text" style="color:#d39a9d; font-size:40px"></i>&nbsp;식단 입력</h2>
   </div>
   <div class="textForm2">
      <input id="memberID" name="memberID" type="text" class="id" required readonly style="background:lightgray">
   </div>
   <div class="textForm2">
      <input id="foodName" name="foodName" type="text" class="id" placeholder="음식 이름" required>
   </div>
   <input type="button" onclick="location.href='menu.html'" class="btn" value="뒤로가기"/>
   <input type="submit" class="btn" value="식단 저장하기"/>
 </form>
</div>
</body>
</html>