<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<nav class="navbar navabar-defaout navbar-fixed-top" style = "border: 1px solid rgba(0, 0, 0, 0.09);">
	<div class="container">
		<div class="col-lg-3 col-md-3 col-sm-9 col-xs-9">
			<div class="brand-wrap">
				<a class="brand" href="${pageContext.request.contextPath}/"> <img src="${pageContext.request.contextPath}/resources/images/wb.png">
				</a>
			</div>
		</div>
		<div class="navbar-wrap col-lg-9 col-md-9 " style = "border-left: 1px solid rgba(0, 0, 0, 0.09); border-right: 1px solid rgba(0, 0, 0, 0.09);">
			<div class="nav-top col-lg-12 col-md-12"id="jhDiv">
				<div class="nav navbar-nav navbar-left">
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="" data-target="#modal_Login" type="button" data-toggle="modal">로그인</a></li>
					<li><a href="${pageContext.request.contextPath}/users/join">회원가입</a></li>
					<li>
					<input name="is_keyword" value="" class="search_form" title="검색" placeholder=" 검색" autocomplete="off" type="text"></li>
				</ul>
			</div>
			<div class="col-lg-12 col-md-12" style="border-top: 1px solid rgba(0, 0, 0, 0.09);">
				<ul class="nav navbar-nav">
					<li ><a href="${pageContext.request.contextPath}/posts/move_list">스케쥴 </a></li>
					
					<li id= "hoon1"class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">WEBRO <i class="glyphicon glyphicon-triangle-bottom"></i></a>
							<ul class="dropdown-menu">
								<li class=" "><a href="${pageContext.request.contextPath}/posts/move_list">정기모임</a></li>
								<li class=" "><a href="${pageContext.request.contextPath}/posts/move_list">코딩Q&A</a></li>
								<li class=" "><a href="${pageContext.request.contextPath}/posts/move_list">이직정보</a></li>
							</ul>
					</li>
					<li class="dropdown ">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">커뮤니티<i class="glyphicon glyphicon-triangle-bottom"></i></a>
							<ul class="dropdown-menu">
								<li class=" "><a href="${pageContext.request.contextPath}/posts/move_list">자유게시판	</a></li>
								<li class=" "><a href="${pageContext.request.contextPath}/posts/move_list">자유갤러리</a></li>
							</ul>
					</li>
					<li class="dropdown "><a href="#">채팅</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>

<!-- Modal -->
<div id="modal_Login" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">로그인</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" role="form" action=""
				method="post">
				<div class="form-group">

					<label for="inputEmail3" class="col-sm-3 control-label"
						style="text-align: left"> Email </label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3"
							value="test@test.com" name="email" />
					</div>
				</div>
				<div class="form-group">

					<label for="inputPassword3" class="col-sm-3 control-label">
						Password </label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							value="test" name="pass" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox" /> Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default" onclick="javascript:form.action='./login';form.submit();">로그인</button>
<!-- 						<button type="button" class="btn btn-default" onclick="javascript:form.action='./joinpage';form.submit();">Sign in</button> -->
					</div>
				</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>