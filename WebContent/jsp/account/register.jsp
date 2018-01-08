<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${cp}/style/default.css" />
<link rel="stylesheet" href="${cp}/style/input.css" />
<title>등록</title>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">회원기본정보</div>
					
					<form id="registerform" action="${cp}/account/Register" method="post">
						<table>
							<tr>
								<th>아이디(id)</th>
								<td>
									<input type="text" id="memberid" name="memberid" style="width:280px"/>
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td>
									<input type="password" id="passwd" name="passwd" style="width:280px" />
								</td>
							</tr>
							<tr>
								<th>비밀번호확인</th>
								<td>
									<input type="password" id="confirm" name="confirm" style="width:280px" />
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>
									<input type="text" id="email" name="email" style="width:280px" />
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="regist" style="height:25px" />
							<input type="button" value="cancel" style="height:25px" 
								onclick="location.href='${cp}/index.jsp'" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>