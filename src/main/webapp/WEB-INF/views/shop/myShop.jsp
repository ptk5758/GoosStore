<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css?ver=1">
	<div class="MyShopBenner">내가 등록한 상품 리스트</div>
	<div id="MyShopBorder" class="MyShop">
		<div class="MyShop_Item">
			<div class="MyShop_Item_Num Cart_Top">번호</div>
			<div class="MyShop_Item_Thum Cart_Top">썸네일</div>
			<div class="MyShop_Item_Name Cart_Top">상품이름</div>
			<div class="MyShop_Item_Price Cart_Top">가격</div>
			<div class="MyShop_Item_Date Cart_Top">등록일</div>
		</div>
	</div>
<script src="/js/MyShop.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>