<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<h2>상품 등록</h2>
	<div class="posting">		
		<div class="posting_border">
			<div class="posting_border_left">
				<div class="posting_item_img">
					<img id="itemimg" src="/img/kain.png">
				</div>
				<div class="posting_item_text">
					<input type="file" id="itemimg" onchange="viewimg(event)" accept="image/*">
				</div>
			</div>
			<div class="posting_border_right">오른쪽</div>
		</div>
	</div>
<script src="/js/shopPosting.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

	