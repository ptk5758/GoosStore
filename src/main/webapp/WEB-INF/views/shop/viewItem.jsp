<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<div class="posting">		
		<div class="posting_border">
			<div class="posting_border_left">
				<div class="posting_item_img">
					<img id="itemimg" src="/6/${item.img_m }">
				</div>
			</div>
			<div id="itemform" class="posting_border_right">
				<input type="hidden" name="UserID" value="${user.userID }">
				<div class="posting_border_iteminput">
					<div class="itemINFO">상품이름</div>
					<div class="viewItemText">${item.itemName }</div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">셀러</div>
					<div class="viewItemText">${item.user }</div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">카테고리</div>
					<div class="viewItemText">${item.itemMidCategory }</div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">상품가격</div>
					<div class="viewItemText">${item.itemPrice }</div>
				</div>
			</div>
		</div>
		<div class="posting_textarea">
			<div style='width: 90%; margin: 0 auto; padding: 25px; font-size: 16px; font-weight: bold; font-family: "넥슨고딕";'>상세 페이지</div>
			<div class="viewItemINFO">
				<c:if test="${item.img_1 != null}"><div style="display: flex; justify-content: center;"><img src="/6/${item.img_1 }"></div></c:if>
				<c:if test="${item.img_2 != null}"><div style="display: flex; justify-content: center;"><img src="/6/${item.img_2 }"></div></c:if>
				<c:if test="${item.img_3 != null}"><div style="display: flex; justify-content: center;"><img src="/6/${item.img_3 }"></div></c:if>
				<div>${item.itemContent }</div>
			</div>
		</div>
		<div class="submitButton" id="submitButton">
			<div class="cartCount">
				<div class="cartCount_Num" id="cartCount">1</div>
				<div class="cartCount_button">
					<div onclick="cartCount(1)">증</div>
					<div onclick="cartCount(-1)">감</div>
				</div>
			</div>
			<div id="BTS" style="align-self: center;"><button onclick="cartIn('${item.itemUID}','${sessionID}')">장바구니</button></div>
		</div>
	</div>
<script src="/js/shopPosting.js?ver=1"></script>
<script src="/js/Cart.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>