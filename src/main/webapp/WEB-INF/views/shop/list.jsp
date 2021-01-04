<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<div class="shopContainer">
		<div class="slideImg"></div>
		<div class="gridborder">
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/케인인님.jpg"></div>
					<div class="gridItem_text">나의 굿즈를 알까?</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/우왁굳.jpg"></div>
					<div class="gridItem_text">굿즈 기모띠</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/쌍베.jpg"></div>
					<div class="gridItem_text">앜!</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/승우아빠.jpg"></div>
					<div class="gridItem_text">굿즈는 제발 사서드세요</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/케인인님.jpg"></div>
					<div class="gridItem_text">나의 굿즈를 알까?</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/케인인님.jpg"></div>
					<div class="gridItem_text">나의 굿즈를 알까?</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/케인인님.jpg"></div>
					<div class="gridItem_text">나의 굿즈를 알까?</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/케인인님.jpg"></div>
					<div class="gridItem_text">나의 굿즈를 알까?</div>
				</div>				
			</div>
			<div class="gridItem">
				<div class="gridItem_img">
					<div><img src="/img/케인인님.jpg"></div>
					<div class="gridItem_text">나의 굿즈를 알까?</div>
				</div>				
			</div>
		</div>
	</div>
	<script>
		var welcome = "${msg}";
		if(welcome != ''){
			alert(welcome);
		}
	</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

