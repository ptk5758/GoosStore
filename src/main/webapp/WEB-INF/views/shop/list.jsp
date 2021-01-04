<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<div class="shopContainer">
		
	</div>
	<script>
		var welcome = "${msg}";
		if(welcome != ''){
			alert(welcome);
		}
	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

