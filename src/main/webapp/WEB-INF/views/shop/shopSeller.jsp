<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<div class="seller_Main">
		<div class="seller_Title">
			<div class="seller_Title_Img"><img src="/6/${seller.img }"></div>
			<div class="seller_Title_text">${seller.comment }</div>
		</div>
		<c:if test="${list != null}">
		<div class="seller_ItemBorder">
			<c:forEach var="item" items="${list }">
			<div class="seller_ItemBorder_Item" data-uid="${item.itemUID }" onclick="viewItem(this,'${seller.sellerID}')">
				<div class="seller_ItemBorder_Item_img"><img src="/6/${item.img_m }"></div>
				<div class="seller_ItemBorder_Item_Name">${item.itemName }</div>
				<div class="seller_ItemBorder_Item_Price">${item.itemPrice } 원</div>
			</div>
			</c:forEach>
		</div>
		</c:if>
		<c:if test="${list == null}">
			<h1 style="background-color: #fff; width: 95%; padding: 15px; text-align: center;">입고 준비중입니다.</h1>
		</c:if>
	</div>
	<script src="/js/shopSystem.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

