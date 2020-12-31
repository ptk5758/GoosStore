<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/adminheader.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="myPage">
			<div class="myPage_UserName">유저관리 목록</div>
			<div class="myPage_Border">
				<div class="myPage_Info">
					<c:forEach var="list" items="${userList }">
					<form class="myPage_Info_Item" method="post">
						<span class="myInfo_Text">${list.userName}</span>
						<span class="myInfo_Text">${list.userID}</span>
						<span class="myInfo_Text">${list.userNickName}</span>
						<span class="myInfo_Text">${fn:substring(list.userSignUpDate,0,10)}</span>
						<span class="myInfo_Text">${list.userLevel}</span>
						<input type="number" name="userLevel" value="${list.userLevel}">
						<input type="hidden" name="userUUID" value="${list.userUUID}">
						<input type="submit" value="변경하기">
					</form>
					</c:forEach>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/views/admin/include/adminheader.jsp"%>

	