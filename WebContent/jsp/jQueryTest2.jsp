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
		$(".test").css("border", "#ffff00 2px solid");
		$("ul > li").css("border", "#ff00ff 1px solid");
		$("li").css("border", "#ff0000 1px solid");
		$(".iphone").css("border", "#ffffff 2px solid");
		
		$("#img1").attr(
				{
					"title":"Exciting",
					"alt" : "Noop!"
				}
		);
		
		$("#img1").attr("title", function(){
			return $("#img1").attr("src");	
		});
		
		var title = $("#img1").attr("title");
		alert(title);
	});
</script>
</head>
<body>
	<div class="test">
		<ul>
			<li>갤럭시</li>
			<li class="iphone">아이폰</li>
			<li class="optimus">
				<img id="img1" src="${cp}/optimus.jpg" title="OOOOOOOOOOOOOOOOOptimus prime~">
				옵티머스
			</li>
		</ul>
	</div>	
</body>
</html>