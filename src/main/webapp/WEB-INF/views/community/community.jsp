<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main1">
<h1>커뮤니티 페이지입니다</h1>
<button onclick="location.href='/community/post'">글등록</button>
<link rel="stylesheet" type="text/css" href="/css/community.css">

	<div class="divTable blueTable">
		<div class="divTableBody">
		<c:forEach var="posting" items="${posting}">
			<div class="divTableRow">
				<div class="divTableCell">
					<p class="title"><a href="/community/postview?postUid=${posting.postUid}">${posting.postTitle}</a></p>
					<div>${posting.postUsername}<div class="textalign">${posting.postDate}</div></div>
				</div>
			</div>
		</c:forEach>	
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>