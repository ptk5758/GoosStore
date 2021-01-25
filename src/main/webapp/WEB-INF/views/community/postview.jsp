<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/community.css">
	<h1>게시물 상세페이지</h1>
<div class="divTable blueTable">
	<div class="divTableBody">
		<div class="divTableRow">
			<div class="divTableCell">
					<p class="titlestyle">${detail.postTitle}</p>
					<p class="">${detail.postUsername}</p>
			</div>
		</div>
		<div class="divTableRow">
			<div class="divTableCell"><p class="">${detail.postContent}</p></div>
		</div>
		<div class="divTableRow">
			<div class="divTableCell">이미지:<img src="/upload/${detail.postImage}" width="500" height="700"></div>
		</div>	
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>