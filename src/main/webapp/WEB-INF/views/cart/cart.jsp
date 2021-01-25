<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="main">
<h1>장바구니페이지입니다</h1>
<div>
	<table>
		<c:set var="sum" value="0"/>
 	<c:forEach var="cart" items="${cart}">
		<tr>
			<td><img src="/upload/${cart.img_m}" width="100" height="100"></td>
			<td>${cart.itemName}</td>
			<td class="amount">${cart.amount}개</td>
			<td>${cart.itemPrice}</td>
			<td></td>
			<td>
			<button onclick="">수량변경</button>
			<button onclick="deletefromcart(${cart.item_uid},'${sessionID}',${cart.amount})">삭제</button>
			</td>
		</tr>
		<c:set var="sum" value="${sum + (cart.itemPrice*cart.amount)}"/>
	</c:forEach>
		<form method="post">
	 	<tr>
	 		<td colspan=6>총합계:<fmt:formatNumber pattern="###,###,###" value="${sum}"/>원</td>
	 		<input type="hidden" value="${sum}" name="sum">
	 		<td><button onclick="order()">구매</button></td>
	 	</tr>
	 	</form>
	</table>

</div>
</div>
<script src="/js/main.js">
</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>