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
		$("#hideIt").click(function(){
			//$("#img1").hide(1000, function(){
			$("#img1").fadeOut(1000, function(){
				alert('image hide');
			});
		});
		
		$("#showIt").click(function(){
			//$("#img1").show(function(){
			$("#img1").fadeIn(1000, function(){
				alert('image shown');
			});
		});
		
		$("#toggle").click(function(){
			if($("#img1").toggle()) {
				alert("image toggled");		
			}
		});
		
		var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
		$(document).keydown(function(e) {
		    kkeys.push( e.keyCode );
		    if ( kkeys.toString().indexOf( konami ) >= 0 ){
		        kkeys = [];
		        alert('Hello, world!');
		    }
		});
	});
</script>
</head>
<body>
	<div id="Header">
		<img id="img1" src="${cp}/optimus.jpg">
	</div>	
	<div>
		<button id="hideIt">Hide</button>
		<button id="showIt">Show</button>
		<button id="toggle">Toggle</button>
	</div>
</body>
</html>