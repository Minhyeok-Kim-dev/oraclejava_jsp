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
<title>자료 업로드</title>
</head>
<body>
	<div id="pageContainer">
		<%@ include file="/include/header.jsp" %>
		
		<div id="content">
			<br/><br/><br/>
			<div id="inputcontent">
				<div id="inputmain">
					<div class="inputsubtitle">업로드 자료정보</div>
					<table>
						<tr>
							<th>제목</th>
							<td>
								${bbs.title}
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td>
								${bbs.uploader}
							</td>
						</tr>
						<tr>
							<th>조회수</th>
							<td>
								${bbs.readCount}
							</td>
						</tr>
						<tr>
							<th>등록일자</th>
							<td>
								<fmt:formatDate value="${bbs.regDate}" pattern="yyyy-MM-dd" />
							</td>
						</tr>
						<tr>
							<th>첨부자료</th>
							<td>
								<c:forEach var="file" items="${bbsFile}">
									<a href="${cp}/bbs/Download?bbsFileNo=${file.bbsFileNo}">
										${file.userFileName}
									</a> &nbsp; ${file.downloadCount}
								</c:forEach>	
							</td>
						</tr>
						<tr>
							<th>자료설명</th>
							<td>
								${bbs.content}
							</td>
						</tr>
					</table>
					<div class="buttons">
						<input type="submit" value="update" style="height:25px" />
						<input type="button" value="cancel" style="height:25px" 
							onclick="location.href='${cp}/bbs/List'" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>