<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="myPage">
			<div class="myPage_UserName">수정페이지</div>
			<div class="myPage_Border">
				<div class="myPage_Info">
				<form id="userForm">
					<input type="hidden" id="userID" value="${userInfo.userID }">
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">닉네임</div>
						<div class="myInfo_value"><input id="userNickName" value="${userInfo.userNickName}"></div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">이메일</div>
						<div class="myInfo_value"><input id="userEmail" value="${userInfo.userEmail }"></div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">전화번호</div>
						<div class="myInfo_value"><input id="userPhone" value="${userInfo.userPhone }"></div>
					</div>
					<div class="myPage_Info_Item">
						<input type="button" value="수정" onclick="userModify()">
						<input type="hidden" name="userUUID" value="${userInfo.userUUID}">
					</div>
				</form>
				</div>
			</div>
		</div>
<script src="/js/userSystem.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

