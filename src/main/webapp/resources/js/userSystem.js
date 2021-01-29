/**
 * 
 */
	$(document).ready(function(){
		/*유저 아이디 검색 ajax*/
		$('#userIDsearch').click(function(){
			var getName = document.getElementById('userName').value;
			var getEmail = document.getElementById('userEmail').value;
			console.log(getName);
			var data = {userName:getName, userEmail:getEmail};
			$.ajax({
			        type		: "POST",
			        url 		: "/usersearch/userIDsearch",
			        data		:  JSON.stringify(data), 
			        contentType : "application/json; charset=UTF-8",
			        success 	: function(data) {
						var jsondata = JSON.parse(data);
						console.log(jsondata);
						if(jsondata.msg != null){
							alert(jsondata.msg);
							return;
						}
						var result = "<div class='IDsearchAfterBorder'>"
										+"<div class='IDsearchAfterItem'><b>"+jsondata.userName+"</b>님 에 대한 아이디검색결과</div>"
										+"<div class='IDsearchAfterItem'><div><span class='IDsearchAfterItem_Text'>아이디:</span><span> <b>"+jsondata.userID+"</b></span></div><div><span class='IDsearchAfterItem_Text'>생성날짜:</span><span>"+jsondata.userSignUpDate.substring(0,10)+"</span></div></div>"
										+"</div>"
										+"<div><div class='IDsearchAfterBorder_button' onclick='loginGo()'>로그인 하러가기</div></div>";
						$('#idsearchForm').html(result);
			        },
			        error		: function(error) {
			        	console.log(error);
			        }
			});
		});
		/*유저 비밀번호 검색 ajax*/
		$('#userPasswordsearch').click(function(){
			var getName = document.getElementById('userName').value;
			var getID = document.getElementById('userID').value;
			var getEmail = document.getElementById('userEmail').value;
			var data = {userName:getName, userID:getID, userEmail:getEmail};
			$.ajax({
				type: "POST",
				url: "/usersearch/userPasswordsearch",
				data: JSON.stringify(data),
				contentType: "application/json; charset=UTF-8",
				success: function(data){
					var jsondata = JSON.parse(data); 
					if(jsondata.msg != null){
							alert(jsondata.msg);
							return;
					}
					var result = `<div class='PasswordsearchAfterBorder'>
									<div class='PasswordsearchAfterItem'><b>${jsondata.userName}</b>님의 대한 아이디<b>'${jsondata.userID}'</b>의 비밀번호 변경하기</div>
									<div class='PasswordsearchAfterItem'><input name='userPassword' placeholder='변경할 비밀번호'></div>
									<div class='PasswordsearchAfterItem'><input placeholder='변경할 비밀번호 확인'></div>
									<div class='PasswordsearchAfterItem'><div class='PasswordsearchAfterButton' onclick='passwordChangeGo()'>비밀번호 변경하기<div></div>
									<input type='hidden' name='userID' value='${jsondata.userID}'>
								  </div>`;
					$('#idsearchForm').html(result);
				},
				error: function(error){
					console.log(error);
				}
			});
		});
	});
	function loginGo(){
		location.href="/user/login";
	}
	function passwordChangeGo(){
		document.getElementById('idsearchForm').submit();
	}
	
	let userModify = () => {
		let userNickName = document.getElementById('userNickName').value;
		let userEmail = document.getElementById('userEmail').value;
		let userPhone = document.getElementById('userPhone').value;
		
		let formData = new FormData();
		formData.set("userPhone", userPhone);
		formData.set("userEmail", userEmail);
		formData.set("userNickName", userNickName);
		let xhp = new XMLHttpRequest();
		xhp.open("POST", "/user/userModify", true);
		xhp.send(formData);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	