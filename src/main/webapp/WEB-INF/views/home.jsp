<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>

<!--  headTag  -->
<%@ include file="/WEB-INF/include/headTag.jsp" %>
<title>WEBRO Main Page</title>
</head>

<body>

<!-- container -->
	<div class="container">
	
<!-- header Top Navbar -->
		<%@ include file="/WEB-INF/include/header.jsp" %>

<!-- body Content -->
		<div class="col-lg-12 col-md-12">
		
<!-- left Side Navbar -->
				<%@ include file="/WEB-INF/include/side.jsp" %>
<!-- body main  -->
				<jsp:include page="${bodyContent}" flush="false" /> 
		</div>
		<!-- footer  -->
	<%-- <%@ include file="/WEB-INF/include/footer.jsp" %> --%>

	</div>


<!-- 로딩 이미지 영역 -->
<div class="wrap-loading display-none">
   	<div><img src="${pageContext.request.contextPath}/resources/images/loading3.gif" id="loadingImg"/ width="80"></div>
</div> 
<!-- chat 영역 -->
<c:if test="${sessionScope.isSession == 'Y'}">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/chatcss.css">

<button type="button" class="chatbutton js-trigger">Chat (45)</button>

<nav class="chat">
    <h2 class="chat__users">Users Online: 45</h2>
    <ul class="chat__wrapper">
        <li class="chat__human">
            <img class="chat__avatar" src="https://robohash.org/joe" alt="" />
            <span class="chat__name">Joe Richardson</span>
        </li>
        
        <li class="chat__human">
            <img class="chat__avatar" src="https://robohash.org/nah" alt="" />
            <span class="chat__name">Bill Gates</span>
        </li>
        
        <li class="chat__human">
            <img class="chat__avatar" src="https://robohash.org/ok" alt="" />
            <span class="chat__name">Steve Jobs</span>
        </li>
        
        <li class="chat__human">
            <img class="chat__avatar" src="https://robohash.org/hi" alt="" />
            <span class="chat__name">Mark Zuckerberg</span>
        </li>
        
        <li class="chat__human">
            <img class="chat__avatar" src="https://robohash.org/bruh" alt="" />
            <span class="chat__name">Denzel Washington</span>
        </li>
    </ul>
</nav>

<div class="conversation">
    <div class="conversation__header">
        Denzel Washington
        <span class="close-msg">&times;</span>
    </div>
    <ul class="conversation__wrap">
        <li class="conversation__msg cf">
            <span>Hey!</span>
        </li>
        
        <li class="conversation__msg cf">
            <span class="right">Yo!</span>
        </li>
        
        <li class="conversation__msg cf">
            <span>How Goes it?</span>
        </li>
        
        <li class="conversation__msg cf">
            <span class="right">Bruh.</span>
        </li>
    </ul>
    
    <input class="input" type="text" placeholder="Enter Message" />
</div>
<script src="${pageContext.request.contextPath}/resources/js/chatjs.js"></script>
</c:if>
</html>
