<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
	<div class="posting"></div>
	<input type="file" id="image" accept="image/*" onchange="setThumbnail(event);"/>
	<div id="image_container"></div>
<script src="/js/shopPosting.js?ver=1"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

