<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/cart.css?ver=1">
	<div id="myCart" class="myCart">
		<div class="Cart_Border">
			<div class="Cart_Item">
				<div class="Cart_Num Cart_Top">번호</div>
				<div class="Cart_Thum Cart_Top">썸네일</div>
				<div class="Cart_Subject Cart_Top">상품이름</div>
				<div class="Cart_Price Cart_Top">가격</div>
				<div class="Cart_TotalPrice Cart_Top">총가격</div>
				<div class="Cart_Check Cart_Top">체크</div>
			</div>
		</div>
	</div>
	<div class="CartButton">
		<div class="cartButtonText">총가격</div>
		<div id="totalPrice">0 원</div>
	</div>
	<div class="paybutton"><button onclick="alert('미구현')">구매</button></div>
<script src="/js/MyCart.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
