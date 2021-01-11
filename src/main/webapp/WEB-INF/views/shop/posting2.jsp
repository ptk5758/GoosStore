<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<body>
<form method="post" enctype="multipart/form-data">
	<div>상품제목<input name="itemName" id="itemName"></div>
	<div>셀러
		<select name="itemTitleCategory">
			<option value="daddyking">아빠킹</option>
			<option value="zzamta">짬타수아</option>
		</select>
	</div>
	<div>미드카테
		<!-- <select name="itemMidCategory">
			<option value="의류">의류</option>
			<option value="악세서리">악세서리</option>
		</select> -->
		<input name="itemMidCategory">
	</div>
	<div>바텀카테
		<select name="itemBottomCategory">
			<option value="모자">모자</option>
			<option value="후드">후드</option>
			<option value="목걸이">목걸이</option>
		</select>
	</div>
	<div>가격<input name="itemPrice" id="itemPrice"></div>
	<div>메인이미지<input type="file" name="files"></div>
	<div>추가이미지<input type="file" name="files"></div>
	<div>추가이미지<input type="file" name="files"></div>
	<div>추가이미지<input type="file" name="files"></div>
	<input type="submit" value="등록">
	</form>
</body>
</html>