<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${cp}/js/jQuery.js"></script>
<script>
	$(document).ready(function() {
		$("#Header").css("border", "#ff0000 1px solid");
	});
</script>
</head>
<body>
	<div id="Header">
		생사 가를 ‘5m 룰’… 이곳에 차 대면 안됩니다
	</div>
</body>
</html>