<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<div class="middle">
			<h1>hello Spring</h1>
			<c:if test="${sessionID != null }">
				<h1>${sessionID } 님 환영합니다.</h1>
			</c:if>
			<h1 onclick="location.href='/shop/list'">굿즈샵보러가기</h1>
			<h1 onclick="location.href='/attend/'">출석체크</h1>
			<h1 onclick="location.href='/ask/'">질답문변</h1>
			<h1 id="test">스팀 api테스트</h1>
			<div>
				<h2 id="userText">트위치 ID를 입력하여주세요</h2>
				<div><input id="twitchID"><button id="testbutton">전송</button></div>
				<img id="testimg">
			</div>
		</div>
		<script>
			sessionStorage.setItem("sessionID","${sessionID}");
		</script>
		<c:if test="${value == 'logout'}">
			<sciprt>
				sessionStorage.clear();
			</sciprt>
		</c:if>
		<script>
			var welcome = "${msg}";
			var myKey = "401EFF3EAE50A2D33FB2E62249BF9B62";		
			let mysteamID ="76561198065106456";
			if(welcome != ''){
				alert(welcome);
			}
			
			$(document).ready(function(){
				$('#testbutton').click(function(){
					var userID = $('#twitchID').val();
					$.ajax({
					    url:"https://api.twitch.tv/kraken/users",
					   	data: "login="+userID,
					    type: "GET",
					    dataType: "json",
					    headers:{
					    	"Accept": "application/vnd.twitchtv.v5+json",
					    	"Client-ID":"uf511d87ct32hi49t0daya01m3xva6"
					    },
					    success : function(data){
					    	var user1 = data.users[0].display_name;
					    	console.log(data.users[0]);
					    	let str = user1+"님환영합니다.";
					    	$('#userText').html(str);
					    	$('#testimg').attr("src",data.users[0].logo);
					    },
					    error : function(error) {
				        	console.log(error);
				        }
					});
				});//testbutton.click
				$('#test').click(function(){
					let jsondata = {key:"401EFF3EAE50A2D33FB2E62249BF9B62",steamid:"76561198065106456",appid:"105600"};
					console.log(jsondata);
					 $.ajax({
					    url:"https://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v1/",
					   	data: jsondata,
					   	contentType: "application/json; charset=utf-8",
					    type: "GET",
					    dataType: "json",
					    success : function(data){
					    	console.log(data);
					    },
					    error : function(error) {
				        	console.log(error);
				        }
					});
				});
			});
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

