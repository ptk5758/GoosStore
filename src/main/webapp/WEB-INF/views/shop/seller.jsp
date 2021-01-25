<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<body>
<form method="post" enctype="multipart/form-data">
	<div>셀러이름<input name="sellerName"></div>
	<div>셀러이메일<input name="sellerEmail"></div>
	<div>셀러도메인<input name="sellerDomain"></div>
	<div>대표이미지(프로필)<input type="file" name="sellerImage"></div>
	<input type="submit" value="신청">
	</form>
</body>
</html>