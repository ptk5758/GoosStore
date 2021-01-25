<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
			
		<div class="main1">
			<div class="slide">
			</div>
			<div class="categories">
			<c:forEach var="seller" items="${seller}">
				<div class="category" onclick="location.href='/shop/midcat?itemTitleCategory=${seller.sellerDomain}'">
				<a><img src="/upload/${seller.sellerImage}"></a>
				<div class="title"><a>${seller.sellerName}</a></div>
				</div>
			</c:forEach>
			</div>
<!-- 			<input type="button" onclick="location.href='/shop/seller'" value="셀러신청">
			<input type="button" onclick="location.href='/shop/write'" value="상품등록"> -->
		</div>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

