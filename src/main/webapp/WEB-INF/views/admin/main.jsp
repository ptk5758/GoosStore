<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/adminheader.jsp"%>
		<h1>관리자님 환영합니다.</h1>
		<h1 onclick="location.href='/admin/user/userTool'">유저관리</h1>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/admin/include/adminfooter.jsp"%>
		

