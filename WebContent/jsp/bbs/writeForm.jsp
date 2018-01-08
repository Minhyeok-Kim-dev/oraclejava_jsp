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
<link rel="stylesheet" href="${cp}/style/input2.css" />
<title>자료 등록</title>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">자료정보</div>
					
					<!-- 파일 전송시 enctype 추가 -->
					<form id="writeForm" action="${cp}/bbs/Write" method="post"
							enctype="multipart/form-data">
						<table>
							<tr>
								<th>제목</th>
								<td>
									<input type="text" id="title" name="title" style="width:580px"/>
								</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>
									${sessionScope.loginUser}
									<input type="hidden" id="uploader" name="uploader" value="${sessionScope.loginUser}" />
								</td>
							</tr>
							<tr>
								<th>첨부자료</th>
								<td>
									<input type="file" id="attach" name="attach" style="width:580px;height:20px" />
								</td>
							</tr>
							<tr>
								<th>자료설명</th>
								<td>
									<textarea id="content" name="content" rows="15" style="width:580px"></textarea>
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="write" style="height:25px" />
							<input type="button" value="cancel" style="height:25px" 
								onclick="location.href='${cp}/bbs/List'" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>