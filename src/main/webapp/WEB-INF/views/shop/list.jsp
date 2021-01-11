<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
		<h1>SHOP페이지입니다</h1>
		<div style="font-size: 24px; font-weight: bold" onclick="location.href='/shop/posting'">글등록하러가기</div>
		<div style="font-size: 24px; font-weight: bold" onclick="location.href='/shop/posting2'">글등록하러가기2</div>
			<div class="slide">		
		</div>
		<div class="categories">
			<div class="category" onclick="location.href='/shop/midcat?itemTopCategory=test'">
				<a><img src="/img/케인인님.jpg"></a>
				<div class="title"><a>나의 굿즈를 알까</a></div>
			</div>
			<div class="category">
				<a href=""><img src="/img/쌍베.jpg"></a>
				<div class="title">쌍베</div>
			</div>
			<div class="category">
				<a href=""><img src="/img/우왁굳.jpg"></a>
				<div class="title">우왁굳</div>
			</div>
			<div class="category">
				<a href=""><img src="/img/승우아빠.jpg"></a>
				<div class="title">승우아빠</div>
			</div>
		</div>	
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

