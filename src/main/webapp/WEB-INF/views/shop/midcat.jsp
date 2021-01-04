<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
		<h1>SHOP페이지입니다</h1>
		<div class="midcatContainer">
			<div class="slide"></div>
			<div class="midcatBorder">
				<div class="midcatBorder_Top">
					<div>의류</div>
					<div>악세서리</div>
					<div>케이스</div>
					<div>생활용품</div>
					<div>그립톡</div>
				</div>
				<div class="midcatBorder_Content">
					<div class="midcatBorder_Left">
						<div>모자</div>
						<div>후드티</div>
						<div>신발</div>
						<div>티셔츠</div>
					</div>
					<div class="midcatBorder_Right">오</div>
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
		

