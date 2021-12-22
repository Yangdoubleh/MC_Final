<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
<script type="text/javascript" src="js/my.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

<style>
.cls1 {
   text-decoration: none;
   color: #337ab7 !important;
}

.cls2 {
   text-align: center;
   font-size: 30px;
}

.board-form {
   position: absolute;
   max-width: 80%;
   width: 100%;
   text-align: center;
   top: 50%;
   left: 50%;
   transform: translate(-50%, -50%);
}

.search_Btn:hover {
   background-color: #ff2f51;
}

.table-striped {
   font-size: 12px;
   color: #333333;
   width: 100%;
   border-width: 1px;
   border-color: #d39a9d;
   border-collapse: collapse;
}

.table-striped th {
   font-size: 12px;
   background-color: #d39a9d;
   border-width: 1px;
   padding: 8px;
   border-style: solid;
   border-color: #d39a9d;
   text-align: center;
}

.table-striped tr {
   background-color: #ffffff;
}

.table-striped td {
   font-size: 12px;
   border-width: 1px;
   padding: 8px;
   border-style: solid;
   border-color: #d39a9d;
   height: 45px;
}

body {
   background-color: rgba(255, 0, 0, 0.1);
}
</style>

<meta charset="UTF-8">
<title>글목록창</title>
</head>

<body>
   <!-- Header Start -->
	<header class="site-header">
		<div class="wrapper site-header__wrapper">
			<nav class="nav"></nav>
			<a href="main.html" class="brand">멀캠세끼</a>
			<nav class="nav">
				<a href="voice_chatbot.html"  class="chat_Btn" type="button"><i
					class="bi bi-chat-right-dots"></i></a>
				<button class="nav__toggle" type="button">
					<i class="bi bi-justify"></i>
				</button>
				<ul class="nav__wrapper">
					<span id="idSpan" class="welcome"><li> 환영합니다!</li></span>
					<li class="nav__item"><a class="sidebar" href="main.html"><i
							class="bi bi-house-fill" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;
							홈</a></li>
					<li class="nav__item"><a class="sidebar" href="menu.html"><i
							class="bi bi-layout-text-window-reverse" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;
							나의 식단</a></li>
					<li class="nav__item"><a class="sidebar" href="basket.html"><i class="bi bi-basket"
							style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;장바구니</a></li>
					<li class="nav__item"><a class="sidebar" href="ingredientrecommand.html"><i class="bi bi-hand-thumbs-up-fill"
							style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;음식 추천</a></li>
					<li class="nav__item"><a class="sidebar" href="boardList"><i class="bi bi-clipboard"
							style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;게시판</a></li>
					<li class="nav__item2"><a class="sidebar" href="circ.html"><i class="bi bi-file-earmark-bar-graph"
							style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;영양소 분석</a></li>
					<br>
					<li class="nav__item"><a class="sidebar" href="mypage.html"><i
							class="bi bi-person-fill" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;마이페이지</a></li>
					<li class="nav__item"><a class="sidebar" id="logoutBtn" href="index.html"><i
							class="bi bi-door-open" style="font-size: 25px;"></i>&nbsp;&nbsp;&nbsp;로그아웃</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- Header End -->

   <div class="board-form">


      <table align="center" border="0" width="80%" class="table table-striped">
         <tr height="10" align="center">
            <th>글번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
         </tr>
         <c:choose>
            <c:when test="${boardList ==null }">
               <tr height="10">
                  <td colspan="4">
                     <p align="center">
                        <b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
                     </p>
                  </td>
               </tr>
            </c:when>
            <c:when test="${boardList !=null }">
               <c:forEach var="article" items="${boardList }"
                  varStatus="articleNum">
                  <tr align="center">
                     <td width="5%">${articleNum.count}</td>
                     <td width="10%">${article.memberID }</td>
                     <td align='left' width="35%"><span
                        style="padding-right: 30px"></span> <c:choose>
                           <c:when test='${article.lvl > 1 }'>
                              <c:forEach begin="1" end="${article.lvl }" step="1">
                                 <span style="padding-left: 20px"></span>
                              </c:forEach>
                              <span style="font-size: 12px;">[답변]</span>
                              <a class='cls1' href="../viewArticle?articleNO=${article.NO}">${article.title}</a>
                           </c:when>
                           <c:otherwise>
                              <a class='cls1' href="../viewArticle?articleNO=${article.NO}">${article.title }</a>
                           </c:otherwise>
                        </c:choose></td>
                     <td width="30%">${article.writeDate}</td>
                  </tr>
               </c:forEach>
            </c:when>
         </c:choose>
      </table>
      <a href="../boardWriteForm"><p class="search_Btn")">글쓰기</p></a>
   </div>

   <script src="js/header.js"></script>
</body>
</html>