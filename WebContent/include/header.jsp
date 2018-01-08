<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="header">
	<div class="title">
		<a href="${cp}">Hello Board</a>
	</div>
	<div class="links">
		<c:if test="${empty sessionScope.loginUser}">
			<a href="${cp}/jsp/account/login.jsp">로그인</a>
			<a href="${cp}/jsp/account/register.jsp">등록</a>
		</c:if>
		<c:if test="${!empty sessionScope.loginUser}">
			${sessionScope.loginUser}님 환영합니다
			<a href="${cp}/account/Logout">로그아웃</a>
		</c:if>
	</div>
</div>
<div id=menu>
	<div>
		<ul>
			<li><a href="${cp}/bbs/List">게시판</a></li>
		</ul>
	</div>
</div>