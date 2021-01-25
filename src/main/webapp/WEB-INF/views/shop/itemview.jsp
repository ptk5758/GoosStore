<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script type="text/javascript" src="/js/shopSystem.js"></script>
	<h1>상품상세페이지</h1>
	
		
	
	
	<div>
		
		<c:forEach var="item" items="${item}">
		
		<div class="mainImage"><img src="/upload/${item.img_m}"></div>
		<div class="order">
			${item.itemTitleCategory}
			<p>${item.itemBottomCategory}</p>
			<h2>${item.itemName}</h2>
			<div class="itemPrice" name="price">가격:${item.itemPrice}</div>
			<input type="button" value="쁘라스" onclick="plus(${item.itemUID})">
			<input type="number" value="1" size="10" id="count">
			<input type="button" value="마이나스" onclick="minus(${item.itemUID})">
			<input type="button" onclick="test(${item.itemUID},'${sessionID}','${item.itemBottomCategory}','${item.itemName}','${item.img_m}','${item.itemPrice}')" value="장바구니담기">
		</div>
		</c:forEach>
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>