<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<div class="middle">
		<h1 onclick="location.href='/shop/list'">SHOP</h1>
		<h1 onclick="location.href='/community/community'">COMMUNITY</h1>
		<h1 onclick="location.href='/page/pagetest'">페이지테스트</h1>	
			<c:if test="${sessionID != null }">
				<h1>${sessionID } 님 환영합니다.</h1>
			</c:if>
		</div>
		
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

