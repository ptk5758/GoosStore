<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="signupContainer">
			<form class="signupBorder" method="post">
				<div class="signupItem">
					<div class="signupText">아이디</div>
					<div class="signupInput">
						<div><input placeholder="ID" name="userID"></div>
						<div class="signupIDCheck">중복확인</div>
					</div>
				</div>
				<div class="signupItem">
					<div class="signupText">이름</div>
					<div class="signupInput">
						<div><input placeholder="NAME" name="userName"></div>
					</div>
				</div>
				<div class="signupItem">
					<div class="signupText">비밀번호</div>
					<div class="signupInput">
						<div><input placeholder="PASSWORD" name="userPassword"></div>
						<div class="signupINFO">안전한 비밀번호를 입력해주세요</div>
					</div>
				</div>
				<div class="signupItem">
					<div class="signupText">닉네임</div>
					<div class="signupInput">
						<div><input placeholder="Nick_Name" name="userNickName"></div>
						<div class="signupINFO">당당히 말할수있는 닉네임을 사용해주세요</div>
					</div>
				</div>
				<div class="signupItem">
					<div class="signupText">이메일주소</div>
					<div class="signupInput">
						<div><input placeholder="Email_Address" name="userEmail"></div>
					</div>
				</div>
				<div class="signupItem">
					<div class="signupText">전화번호</div>
					<div class="signupInput">
						<div><input placeholder="Phone_Number" name="userPhone"></div>
						<div class="signupINFO">'-' 는 빼서 입력해주세요</div>
					</div>
				</div>
				<div class="signupButton">
					<input type="submit" value="회원가입">
				</div>
			</form>
		</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
