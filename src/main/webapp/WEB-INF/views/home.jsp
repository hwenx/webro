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
</body>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.12.0.js"></script>
</html>
