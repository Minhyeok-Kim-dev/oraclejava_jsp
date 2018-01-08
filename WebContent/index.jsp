<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cp}/style/default.css" />
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/include/header.jsp" %>
		<div id="content">
			<br/><br/><br/>
			<h2 style="text-align:center">Welcome to oraclejava!</h2>
		</div>
	</div>
</body>
</html>