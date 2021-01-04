<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<div class="middle">
			<h1>hello Spring</h1>
			<c:if test="${sessionID != null }">
				<h1>${sessionID } 님 환영합니다.</h1>
			</c:if>
			<h1 onclick="location.href='/shop/list'">굿즈샵보러가기</h1>
		</div>
		<script>
			var welcome = "${msg}";
			var myKey = "E0056A21EFA2F430FE0A62F9D0F55482";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

