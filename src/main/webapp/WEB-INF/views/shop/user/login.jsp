<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="loginContainer">
			<form id="loginForm" class="loginBorder" method="post">
				<div class="loginInput"><input placeholder="아이디" name="userID"></div>
				<div class="loginInput"><input placeholder="비밀번호" name="userPassword"></div>
				<div class="loginButton"><div onclick='document.getElementById("loginForm").submit()'>로그인</div></div>
				<div class="loginoption">
					<div class="loginoption_Item" onclick="location.href='/user/idsearch'">아이디 찾기</div>
					<div class="loginoption_Item" onclick="location.href='/user/passwordsearch'">비밀번호 찾기</div>
					<div class="loginoption_Item" onclick="location.href='/user/signup'">회원가입</div>
				</div>
			</form>
		</div>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>