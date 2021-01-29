<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="myPage">
			<div class="myPage_UserName">${userVO.userName } 님 의 페이지</div>
			<div class="myPage_Border">
				<div class="myPage_Info">
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">아이디</div>
						<div class="myInfo_value">${userVO.userID }</div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">닉네임</div>
						<div class="myInfo_value">${userVO.userNickName }</div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">레벨</div>
						<div class="myInfo_value">${userVO.userLevel }</div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">이메일</div>
						<div class="myInfo_value">${userVO.userEmail }</div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">전화번호</div>
						<div class="myInfo_value">${userVO.userPhone }</div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">스팀아이디</div>
						<div class="myInfo_value">${userVO.userSteamID }</div>
					</div>
					<div class="myPage_Info_Item">
						<div class="myInfo_Text">회원가입 날짜</div>
						<div class="myInfo_value">${userVO.userSignUpDate }</div>
					</div>
					<div class="myPage_Info_Item">
						<div><button onclick="location.href='/user/userModify'">회원수정하기</button></div>
					</div>
				</div>
			</div>
		</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

