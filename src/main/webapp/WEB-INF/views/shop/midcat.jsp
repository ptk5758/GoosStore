<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
<c:forEach var="seller" items="${seller}">

	<div class="main1">
		<div class="mainslider" id="slider">
			<img class="slide" src="/img/game1.jpg"> <img class="slide"
				src="/img/game2.jpg"> <img class="slide" src="/img/game3.jpg">
			<img class="slide" src="/img/game4.jpg">
		</div>
			<button class="slideleft" onclick="plusDivs(-1)">left</button>
			<button class="slideright" onclick="plusDivs(+1)">right</button>
		<div class="slide"></div>
		<div class="intro"></div>
		<div class="midcat">
			<div class="midcatBorder">
				<div class="midcatBorder_Top">
					<div onclick="getAllitemList('${seller.sellerDomain}')" id="all">전체</div>
					<div onclick="getCategory('의류','${seller.sellerDomain}')">의류</div>
					<div onclick="getCategory('악세서리','${seller.sellerDomain}')">악세서리</div>
					<div onclick="getCategory('케이스','${seller.sellerDomain}')">케이스</div>
					<div onclick="getCategory('생활용품','${seller.sellerDomain}')">생활용품</div>
				</div>
				<script>
					var welcome = "${msg}";
					if (welcome != '') {
						alert(welcome);
					};
					var value = "<c:out value="${seller.sellerDomain}"/>";
					$(document).ready(function() {
						getAllitemList(value);
					});
				</script>
</c:forEach>

<div class="midcatBorder_Content">
	<div class="midcatBorder_Left"></div>
	<div class="midcatBorder_Right">
		<%-- 	<c:forEach var="item" items="${item}">
						<div>
							<div><img src="/upload/${item.img_m}" width="100" height="200"></div>
							<div>${item.itemName}</div>
							<div>${item.itemPrice}</div>
						</div>
					</c:forEach> --%>
	</div>
</div>
</div>
</div>
</div>
<input type="button" onclick="location.href='/shop/write'" value="상품등록">

<script src="/js/shopSystem.js">
	
</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>


