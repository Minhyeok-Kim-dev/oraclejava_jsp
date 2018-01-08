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
			url : "${cp}/GetMembers",
			success : function(data) {
				$.each(data, function() {
					var trElement = $("table .header").clone().removeClass().empty();
					$("table tbody").append(trElement.addClass("content"));
					
					trElement.append("<td>" + this.memberId + "</td>");
					trElement.append("<td>" + this.passwd + "</td>");
					trElement.append("<td>" + this.email + "</td>");
					trElement.append("<td>" + this.userType + "</td>");
					trElement.append("<td>" + this.active + "</td>");
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
					<th>사용자id</th>
					<th>비밀번호</th>
					<th>email</th>
					<th>사용자type</th>
					<th>active</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>