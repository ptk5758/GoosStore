<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/adminheader.jsp"%>
		<h1>관리자님 환영합니다.</h1>
		<!-- <h1 onclick="location.href='/admin/user/userTool'">유저관리</h1> -->
		<div class="adminBorder">
			<div class="adminMenu">
				<div class="adminMenu_Item" onclick="getUserList()">유저관리</div>
				<div class="adminMenu_Item" onclick="getAskList()">질문답변</div>
				<div class="adminMenu_Item">3</div>
				<div class="adminMenu_Item">4</div>
				<div class="adminMenu_Item">5</div>
			</div>
			<div class="adminContent">
				그때그때마다
			</div>
		</div>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
		<script src="/js/AdminAsk.js?ver=1"></script>
		<script src="/js/AdminUser.js?ver=1"></script>
<%@ include file="/WEB-INF/views/admin/include/adminfooter.jsp"%>
		

