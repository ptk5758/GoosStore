<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="loginContainer">
			<form id="idsearchForm" class="loginBorder" method="post">
				<div class="loginInput"><input placeholder="이름" id="userName"></div>
				<div class="loginInput"><input placeholder="아이디" id="userID"></div>
				<div class="loginInput"><input placeholder="이메일주소" id="userEmail"></div>
				<div class="loginButton"><div id="userPasswordsearch">비밀번호 찾기</div></div>
			</form>
		</div>
		<script src="/js/userSystem.js"></script><!--유저 서치 ajax  -->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>