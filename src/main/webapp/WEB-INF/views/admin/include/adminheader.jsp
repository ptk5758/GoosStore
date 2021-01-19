<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="/css/adminmain.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<!-- ***메인 js 파일은 푸터에 존재함*** -->
</head>
<body>
	<div class="container">
		<div class="top">
			<div class="top_Title" onclick="location.href='/'">업적보라</div>
			<div class="top_Signup">
				<c:if test="${sessionID == null }">
					<div class="top_Signup_Item" onclick="location.href='/user/login'">로그인</div>
					<div class="top_Signup_Item" onclick="location.href='/user/signup'">회원가입</div>
				</c:if>
				<c:if test="${sessionID != null }">
					<c:if test="${sessionLevel == 10 }"><div class="top_Signup_Item">관리자 페이지</div></c:if>
					<div class="top_Signup_Item">Lv.${sessionLevel }${sessionName }님</div>
					<div class="top_Signup_Item" onclick="location.href='/user/logout'">로그아웃</div>
					<div class="top_Signup_Item" onclick="location.href='/user/mypage?sessionID=${sessionID}'">마이페이지</div>
				</c:if>
			</div>
		</div>
		