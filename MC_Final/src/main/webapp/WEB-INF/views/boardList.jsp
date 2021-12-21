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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<meta charset="UTF-8" />
<title>멀캠세끼의 게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="styles/reset.min.css" />
  <link rel="stylesheet" href="styles/style.css" />
  <link rel="stylesheet" href="styles/header.css" />
  
  <script src="js/header.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
 <style>
 
 
   .cls1 {text-decoration:none;}
   .cls2{text-align:center; font-size:30px;}
 

 .search_Btn:hover {
 background-color:#ff2f51;
 }

table {
 
margin-left: 280px;
margin-top: 200px;
}

.table-striped {
font-size:12px;
color:#333333;
width:100%;
border-width: 1px;
border-color: #d39a9d;
border-collapse: collapse;


}
.table-striped th {

font-size:12px;
background-color:#d39a9d;
border-width: 1px;
padding: 8px;
border-style: solid;
border-color: #d39a9d;
text-align: center;

}

.table-striped tr {

background-color:#ffffff;
}

.table-striped td {
font-size:12px;
border-width: 1px;
padding: 8px;
border-style: solid;
border-color:#d39a9d;
height: 45px;
}


body {

background-color: rgba(255,0,0,0.1);
}


/*
.table-striped{
border-collapse: separate;
  border-spacing: 1px;
  text-align: center;
  line-height: 1.5;


}
.table-striped th {
  width: 155px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
  background: #d39a9d ;
  text-align: center;
}
.table-striped td {
  width: 155px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #eee;
} */
  </style>
  <meta charset="UTF-8">
  <title>글목록창</title>
</head>
<script>
	function fn_articleForm(url){
	  var id=getCookie("id");		
	  if(id){
                document.cookie="board_id="+id;
	    location.href=url;
	  }else{
	    alert("로그인 후 글쓰기가 가능합니다.")
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

<body>	<!-- Header Start -->
	<header class="site-header">
		<div class="wrapper site-header__wrapper">
			<nav class="nav"></nav>
			<a href="#" class="brand">멀캠세끼</a>
			<nav class="nav">
				<a href="chatbot.html" class="chat_Btn" type="button"><i
					class="bi bi-chat-right-dots"></i></a>
				<button class="nav__toggle" type="button">
					<i class="bi bi-justify"></i>
				</button>
				<ul class="nav__wrapper">
					<li class="welcome">aaa님 환영합니다!</li>
					<li class="nav__item"><a class="sidebar" type="button" href="main.html"><i
							class="bi bi-house-fill" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;
							홈</a></li>
					<li class="nav__item"><a class="sidebar" href="board.html"><i
							class="bi bi-layout-text-window-reverse" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;
							나의 식단</a></li>
					<li class="nav__item2"><a class="sidebar" href="basket.html"><i class="bi bi-basket"
							style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;장바구니</a></li>
					<br>
					<li class="nav__item"><a  class="sidebar" href="mypage.html"><i
							class="bi bi-person-fill" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;마이페이지</a></li>
					<li class="nav__item"><a class="sidebar" href="index.html" id="logoutBtn"><i
							class="bi bi-door-open" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;로그아웃</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- Header End -->
      
<div class="container">

							
<table align="center" border="0"  width="80%"  class="table table-striped">
  <tr height="10" align="center"  >
     <th >글번호</th>
     <th >작성자</th>              
     <th >제목</th>
     <th >작성일</th>
  </tr>
<c:choose>
  <c:when test="${boardList ==null }" >
    <tr height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 글이 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  <c:when test="${boardList !=null }" >
    <c:forEach  var="article" items="${boardList }" varStatus="articleNum" >
     <tr align="center">
	<td width="5%">${articleNum.count}</td>
	<td width="10%">${article.memberID }</td>
	<td align='left'  width="35%">
	  <span style="padding-right:30px"></span>
	   <c:choose>
	      <c:when test='${article.lvl > 1 }'>  
	         <c:forEach begin="1" end="${article.lvl }" step="1">
	              <span style="padding-left:20px"></span>    
	         </c:forEach>
	         <span style="font-size:12px;">[답변]</span>
                   <a class='cls1' href="../viewArticle?articleNO=${article.no}">${article.title}</a>
	          </c:when>
	          <c:otherwise>
	            <a class='cls1' href="../viewArticle?articleNO=${article.no}">${article.title }</a>
	          </c:otherwise>
	        </c:choose>
	  </td>
	  <td  width="30%">${article.writeDate}</td> 
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
</table>
</div>
<center>
<a href="../boardWriteForm"><p class="search_Btn">글쓰기</p></a>
</center>

	<script src="js/circ.js"></script>
	<script src="js/header.js"></script>
</body>
</html>
