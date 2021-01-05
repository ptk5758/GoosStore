<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<div class="middle">
			<h1>hello Spring</h1>
			<c:if test="${sessionID != null }">
				<h1>${sessionID } 님 환영합니다.</h1>
			</c:if>
			<h1 onclick="location.href='/shop/list'">굿즈샵보러가기</h1>
			<h1 id="test">스팀 api테스트</h1>
		</div>
		<script>
			var welcome = "${msg}";
			var myKey = "12E7F99A33E034910C13A1B801C99884";			
			
			if(welcome != ''){
				alert(welcome);
			}
			var xhr = new XMLHttpRequest();
			xhr.open('GET', 'https://api.twitch.tv/kraken', true);
			xhr.setRequestHeader('Client-ID', 'sznaposigz3g0vzmz1lvfb955myy81');
			xhr.onload = function(data){
			  console.log(data);
			};
			xhr.onerror = function(error){
			  console.log(error.target.status);
			};
			xhr.send();
			/* $.ajax({
				type : 'GET',
				url : "https://api.twitch.tv/kraken",
				dataType : 'jsonp',//cross-domain 이슈를 회피하기 위해 jsonp요청을 한다. 
				success : function(data){
					console.log(data)
				},
				error : function(error) {
		        	console.log(error);
		        }//callback이란 함수를 나의 success function에 매핑시켜 콜백요청을 처리할 것이다. 
			}); */

			
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

