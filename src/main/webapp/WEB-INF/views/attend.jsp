<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/attend.css">
	<div class="attend">
		<div class="attendTitle">
			<div class="attendTitle_Text">출석체크</div>
		</div>
		<div class="attendBorder">
			<div class="nowYear" id="nowYear" data-year="2021">2021년</div>
			<div class="selectDate">
				<div>9999년 12월 31일</div>
			</div>
			<div class="attendInputBorder">
				<c:if test="${sessionNickName == null}">
					<div class="attendUser">
						<div>게스트</div>
					</div>
				</c:if>
				<c:if test="${sessionNickName != null}">
					<div class="attendUser">
						<div>${sessionNickName }</div>
					</div>
				</c:if>
				<!-- action="/restAttend/attendInsert" method="post"  -->
				<div class="attendInputForm">					
					<div class="attendInput"><input id="content" name="content" placeholder="출석체크를 하고 경험치를 올리세요"></div>
					<div class="attendButton"><input type="button" value="출석체크" onclick="attendInsert('${sessionID}','${sessionNickName}')"></div>
				</div>
			</div>
			<div class="attendList">
				<div class="attendListItem">
					<div class="listUserINFO">
						<div>Lv.10</div>
						<div><b>간디가어딜간디</b></div>
						<div class="UserINFO_date">2021-01-12</div>
					</div>
					<div class="listContent">
						<p>ㄹㅇㅋㅋ 만쳐</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/attendSystem.js"></script>
	<script>
		let welcome = "${msg}";
		if(welcome != ''){
			alert(welcome);
		}
	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		