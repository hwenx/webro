<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<meta charset="utf-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<meta http-equiv="Content-Type" content="text/html; charset=ksc5601">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sidenavbar.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/pagestyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.simple-dtpicker.css">

<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.12.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.paging.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap/holder.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.paginate.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery.battatech.excelexport.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery.simple-dtpicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>


<script type="text/javascript">
//로그인 프로세스 실패 시
var isState = '${sessionScope.isState}';
if('N' === isState){
	alert('아이디 혹은 비밀번호가 맞지 않습니다.')
}
//모든 ajax 요청 전 후 처리
$.ajaxSetup({
	 beforeSend: function() {
		$('.wrap-loading').removeClass('display-none');
	 },
	 complete: function() {
		 $('.wrap-loading').addClass('display-none');
	 }
});
</script>
<!-- 
<script>
$(document).ready(function(){
	// sidevar 펼쳐지게
	var path = window.location.pathname; //   /howdobo/services/quicklink/move_info
	var side_position = "#"+path.split("/")[2]+"_side";
	var underlinePathName = path.split("/")[2]+"/"+path.split("/")[3]+"/";
	
	$(side_position).trigger("click");
	
	// 선택한 엘리먼트 밑줄, 굵은 글 표시
	$(".nav .nav-second-level > li > a").each(function(){
       	if($(this).attr("href").indexOf(underlinePathName) > -1){
       		$(this).attr("style", "background: #2AA088;text-decoration:underline; font-weight: bold;")
/*        		$(this).attr("style", "text-decoration:underline; font-weight: bold;") */
       		return;
       	}
    });
});
</script>
 -->