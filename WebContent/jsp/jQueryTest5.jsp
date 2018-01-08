<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajaxTest</title>
<script src="${cp}/js/jQuery.js"></script>
<script>
	$(document).ready(function() {
		$.ajax({
			type : "get",
			//data : {"command", "select"},
			dataType : "json",
			url : "${cp}/GetBbs",
			success : function(data) {
				$.each(data, function() {
					var trElement = $("table .header").clone().removeClass().empty();
					$("table tbody").append(trElement.addClass("content"));
				
					trElement.append("<td>" + this.bbsNo + "</td>");
					trElement.append("<td>" + this.title + "</td>");
					trElement.append("<td>" + this.uploader + "</td>");
					trElement.append("<td>" + this.readCount + "</td>");
					trElement.append("<td>" + this.regDate + "</td>");
				});
			},
			error : function(request, status) {
				alert(status);
			}
		});
	});
</script>
<style>
	table {
		width : 500;
		border : 1px solid gray;
		font-family : Verdana, Geneva, Arail, Helvetica, sans-serif;
		font-size : 12px;
	}
	
	td {
		border : 1px solid gray;
		text-align : center;
	}
	
	tr.header * {
		background-color : #666666;
		color : white;
	}
</style>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr class="header">
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>