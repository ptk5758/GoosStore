<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function use(){
	var parent = window.opener; 
	parent.document.getElementById("check").value = '1';
}
</script>
<body>
<h1>${msg}</h1>

<input type="button" value="사용하기" onclick="use()">
</body>
</html>