<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
		<h1>SHOP페이지입니다</h1>
		<div class="midcatContainer">
			<div class="slide"></div>
			<div class="midcatBorder">
				<div class="midcatBorder_Top">
					<div onclick="getCategory('all')">전체</div>
					<div onclick="getCategory('의류')">의류</div>
					<div onclick="getCategory('악세서리')">악세서리</div>
					<div onclick="getCategory('케이스')">케이스</div>
					<div onclick="getCategory('생활용품')">생활용품</div>
				</div>
				<div class="midcatBorder_Content">
					<div class="midcatBorder_Left">
						<div>전체</div>
					</div>
					<div class="midcatBorder_Right">
						<c:forEach var="list" items="${shop}">
							<div class="shopListItem" onclick="viewItem('${list.itemUID}')">
								<div><img width="150" height="150" src="/img/woo.jpg"></div>
								<div>${list.itemName}</div>
								<div>${list.itemPrice}</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
		<script src="/js/shopSystem.js"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

