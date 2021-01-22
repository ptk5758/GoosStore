/**
 * 
 */

	console.log("adminUserListHiHi");
	
	let getUserList = () => {
		console.log("get_UserList");
		$(function(){
			let board = $('.adminContent');
			//console.log(board);
			let xhp = new XMLHttpRequest();
			xhp.open("get", "/usersearch", true);
			xhp.send(null);
			xhp.onreadystatechange = () =>{
				if(xhp.status === 200 && xhp.readyState === 4){
					let data = xhp.responseText;
					let jsonData = JSON.parse(data);
					let totalUser = jsonData.count;
					let userArray = jsonData.list;
					let result = `
						<div class="Admin_UserBorder">
							<div class="Admin_UserList">
					`;
					for(let i=0; i<userArray.length; i++){
						let list = userArray[i];
						result += `
							<div class="Admin_User" onclick="viewUser(this)" data-order="${i}">
								<div class="Admin_User_Num"><div class="circle"><div>${totalUser}</div></div></div>
								<div class="Admin_User_Name">${list.userName}</div>
								<div class="Admin_User_ID">${list.userID}</div>
								<div class="Admin_User_NickName">${list.userNickName}</div>
								<div class="Admin_User_Email">${list.userEmail}</div>
								<div class="Admin_User_Level">${list.userLevel}</div>
							</div>
						`;
						totalUser--;
					}
					result += `</div></div>`;
					board.html(result);
				}
			}
		});
	}
	
	let viewUser = (item) => {
		//console.log(item);
		$(function(){
			
			let index = $(item).data('order');
			
			//$(item).attr("onclick","none");
			//$(item).attr("onclick","viewUser_close()");
			
			let xhp = new XMLHttpRequest();
			xhp.open("get", "/usersearch", true);
			xhp.send(null);
			xhp.onreadystatechange = () =>{
				if(xhp.status === 200 && xhp.readyState === 4){
					let jsonData = JSON.parse(xhp.responseText);
					let user = jsonData.list[index];
					//console.log(user);
					let result = `<div class="Admin_ViewUserBorder">`;
					result +=`
						<div class="userINFO">
							<div class="INFO_title">이름</div>
							<div>${user.userName}</div>
						</div>
						<div class="userINFO">
							<div class="INFO_title">닉네임</div>
							<div>${user.userNickName}</div>
						</div>
						<div class="userINFO">
							<div class="INFO_title">아이디</div>
							<div>${user.userID}</div>
						</div>
						<div class="userINFO">
							<div class="INFO_title">이메일</div>
							<div>${user.userEmail}</div>
						</div>
						<div class="userINFO">
							<div class="INFO_title">가입날짜</div>
							<div>${user.userSignUpDate}</div>
						</div>
						<div class="userINFO">
							<div class="INFO_title">연락처</div>
							<div>${user.userPhone}</div>
						</div>
						<div class="userINFO">
							<div class="INFO_title">등급</div>
							<div>${user.userLevel}</div>
						</div>
						<div class="userIMG">
							<div><img src="/img/2222.png"></div>
							<div><button class="closeButton" onclick="viewUser_close()">닫기</button></div>
						</div>
					`;
					
					result += `</div>`;
					$(item).append(result);
				}
			}
		});
	}
	
	let viewUser_close = () =>{
		getUserList();
	}
	
	
	
	
	
	
	
	
	
	
	