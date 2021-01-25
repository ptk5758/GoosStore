<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<body>
<h1>커뮤니티 글쓰기페이지</h1>
<form method="post" enctype="multipart/form-data">
	<div>작성자<input name="postUsername" id="postUsername" value="${sessionID}"></div>
	<div>제목<input name="postTitle" id="postTitle"></div>
	<div>이미지<input type="file" name="file"></div>
	<div>내용<input type="text" name="postContent"></div>
	<input type="submit" value="등록">
	</form>
</body>
</html>