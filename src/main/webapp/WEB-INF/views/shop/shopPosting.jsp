<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<h2>상품 등록</h2>
	<div class="posting">		
		<div class="posting_border">
			<div class="posting_border_left">
				<div class="posting_item_img">
					<img id="itemimg" src="/img/케인인님.jpg">
				</div>
				<div class="itemINFO">대표 이미지</div>
				<div class="posting_item_text">
					<input type="file" id="itemimg" onchange="viewimg(event)" accept="image/*">
				</div>
			</div>
			<div class="posting_border_right">
				<div class="posting_border_iteminput">
					<div class="itemINFO">상품이름</div>
					<div class="iteminput"><input></div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">셀러</div>
					<div class="iteminput"><input></div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">카테고리</div>
					<div class="iteminput"><input></div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">상품가격</div>
					<div class="iteminput"><input></div>
				</div>
				<div class="posting_border_iteminput">
					<div class="itemINFO">추가이미지</div>
					<div class="iteminput"><input type="file" multiple="multiple"></div>
				</div>
			</div>
		</div>
		<div class="posting_textarea">
			<div style='width: 90%; margin: 0 auto; padding: 25px; font-size: 16px; font-weight: bold; font-family: "넥슨고딕";'>상세 페이지 내용</div>
			<textarea id="inputcontent"></textarea>
		</div>
		<div class="submitButton">
			<div><button>상품등록하기</button></div>
		</div>
	</div>
<script src="/js/shopPosting.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

	