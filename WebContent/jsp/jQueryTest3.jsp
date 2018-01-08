<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jqt3</title>
<script src="${cp}/js/jQuery.js"></script>
<script>
	$(document).ready(function() {
		$("#img1").animate({
			width:"-100%",
			opacity:0.5
		}, 5000);
	});
</script>
</head>
<body>
	<div id="Header">
		<img id="img1" src="${cp}/optimus.jpg">
	</div>
</body>
</html>