<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<div class="middle">
			<h1>hello Spring</h1>
			<c:if test="${sessionID != null }">
				<h1>${sessionID } 님 환영합니다.</h1>
			</c:if>
			<h1 onclick="location.href='/shop/list'">굿즈샵보러가기</h1>
			<h1 onclick="location.href='/attend/'">출석체크</h1>
			<h1 onclick="location.href='/ask/'">질답문변</h1>
			<h1 id="test">스팀 api테스트</h1>
			<div>
				<h2 id="userText">트위치 ID를 입력하여주세요</h2>
				<div><input id="twitchID"><button id="testbutton">전송</button></div>
				<img id="testimg">
			</div>
			<h1>포토폴리오용도의 사이트입니다.</h1>
		</div>
		<script>
			sessionStorage.setItem("sessionID","${sessionID}");
			sessionStorage.setItem("sessionLevel","${sessionLevel}");
			sessionStorage.setItem("sessionNickName","${sessionNickName}");
		</script>
		<c:if test="${value == 'logout'}">
			<sciprt>
				sessionStorage.clear();
			</sciprt>
		</c:if>
		<script>
			var welcome = "${msg}";
			var myKey = "401EFF3EAE50A2D33FB2E62249BF9B62";		
			let mysteamID ="76561198065106456";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

