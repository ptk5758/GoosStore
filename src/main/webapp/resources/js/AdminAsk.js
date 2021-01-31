/**
 * 
 */
	
	let getAskList = function (){
		console.log("질문답변 리스트 가져오기");
		$(function(){
			$.ajax({
			type : "GET",
			url : "/RestAsk/",
			dataType : "JSON",
			success : function(data){
				let totalcount = data.count;
				let result = "<div class='admin_AskListBorder'>";
				result += `
					<div class="admin_searchOption">
						<div>
							<select onchange="viewLimit(this)">
								<option>All</option>
								<option>5</option>
								<option>10</option>								
							</select>
						</div>
						<div>
							<select>
								<option>카테고리 선택</option>
								<option>기타</option>
								<option>채용문의</option>
								<option>상품문의</option>
								<option>기능문의</option>								
							</select>
						</div>
						<div>
							<input placeholder="제목">
						</div>
						<div>
							<button>검색하기</button>
						</div>
					</div>
					<div id="admin_AskBorder">
				`;
				let jsondata = data.list;
				for(let i=0; i<jsondata.length; i++){
					result += `
						<div class="admin_AskList" data-uid="${jsondata[i].askUID}" onclick="viewAsk(this)">
							<div class="admin_AskListItem_Num">${totalcount}</div>
							<div class="admin_AskListItem_Category">${jsondata[i].category}</div>
							<div class="admin_AskListItem_Subject">${jsondata[i].subject}</div>
							<div class="admin_AskListItem_UserEmail">${jsondata[i].userEmail}</div>
							<div class="admin_AskListItem_FeedBack">${jsondata[i].active == 1 ? "미답변": jsondata[i].active == 2 ? "읽음":"답변완료"}</div>
						</div>`;
					totalcount--;
				}
				result += "</div></div>";
				$('.adminContent').html(result);
			},
			error : function(error){
				console.log(error);
			}
			});
		});
	}
	
	let viewAsk = function(item){		
		$(function(){
			let askUID = $(item).data('uid');
			$.ajax({
				url : "/RestAsk/"+askUID,
				type : "GET",
				dataType : "json",
				success : function(data){
					console.log(data);
					let result = "<div class='admin_ViewAsk'>";
					result += `
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text">제목</div>
							<div class="admin_ViewAskItem_value">${data.subject}</div>
						</div>
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text">분류</div>
							<div>${data.category}</div>
						</div>
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text">업로드 날짜</div>
							<div>${data.uploadDate}</div>
						</div>
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text">이메일</div>
							<div>${data.userEmail}</div>
						</div>
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text">연락처</div>
							<div>${data.phone}</div>
						</div>
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text">답변상태</div>
							<div id="active" data-active="${data.active}">${data.active == 1 ? "미답변": data.active == 2 ? "읽음":"답변완료"}</div>
						</div>
						<div class="admin_ViewAskItem">
							<div class="admin_ViewAskItem_Text" id="a">문의 내용</div>
							<div class="admin_ViewAskItem_askcontent">
								${data.file1 === "null" ? "":`<div class="askImg"><img src="/6/${data.file1}"></div>`}
								${data.file2 === "null" ? "":`<div class="askImg"><img src="/6/${data.file2}"></div>`}
								${data.file3 === "null" ? "":`<div class="askImg"><img src="/6/${data.file3}"></div>`}
								<div>${data.content}</div>
							</div>							
						</div>
						<div class="admin_ViewAskButton" data-uid="${data.askUID}">
							<div><input type="button" value="읽음처리" onclick="askActiveUpdate('2','${data.askUID}')"></div>
							<div><input type="button" value="답변하기" onclick="adminFeed()"></div>
						</div>
						
						
					`;
					result += "</div>";
					$('.adminContent').html(result);
				},
				error : function(error){
					console.log(error);
				}
			});
		});
	}
	
	let askActiveUpdate = function(value,uid){
		console.log(`${value},${uid}<<<<<<<<<<<<<<<`);
		$(function(){
			$.ajax({
				url : `/RestAsk/${uid}?active=${value}`,
				type : "PATCH",
				suesuccess : function(data){
					console.log(data);
					alert("성공");
				},
				error : function(error){
					console.log(error);
				}
			});
		});
	}
	
	let adminFeed = function (){
		$(function(){
			$('#a').html("답변중");
			let result = "";
			result += `
				<div class="admin_FeedTextarea">
					<textarea id="requestContent"></textarea>
					<div clas="admin_FeedFileUploadButton"><input type="file" id="askFile" multiple="multiple"></div>
					<div class="admin_FeedSendButton">
						<input type="button" value="답변하기" onclick="adminFeedDo()">
						<input type="button" value="삭제하기">
					</div>
				</div>
			`;
			$('.admin_ViewAskItem_askcontent').html(result);
		});
	}
	let adminFeedDo = function() {
		console.log("gdgd");
		$(function(){
			let content = document.getElementById('requestContent').value;
			let requestfile = document.getElementById('askFile');
			let askUID = $('.admin_ViewAskButton').data('uid');
			let formData = new FormData();
			formData.append("askUID", askUID);
			formData.append("content", content);
			formData.append("admin", sessionStorage.getItem("sessionNickName"));
			for(let file of requestfile.files){
				formData.append("file",file);
			}
			let xhp = new XMLHttpRequest();
			xhp.open("POST","/AdminFeed/",true);
			xhp.send(formData);
			console.log(xhp.responseText);
			alert("답변작성이 완료되었습니다.");
			$('#a').html("답변완료");
			$('.admin_ViewAskItem_askcontent').html("<h1>답변완료</h1>");
			$.ajax({
				url: `/RestAsk/${askUID}?active=3`,
				type: "PATCH",
				success : function(data){console.log(data);},
				error: function(error){console.log("알수없는 오류로 인헤 실패");}
			});
		});
	}
	
	let viewLimit = function(item){
		console.log(item.value);
		
		if(item.value === "All"){
			getAskList();
		} else {
			let limit = item.value;
			let xhp = new XMLHttpRequest();
			xhp.open("GET", '/RestAsk/?page='+limit, true);
			xhp.send(null);
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					let data = JSON.parse(xhp.responseText);
					console.log(data);
					let list = data.list;
					let totalcount = data.count;
					let result = "";
					for(let i=0; i<list.length; i++){
						let item = list[i];
						result += `
						<div class="admin_AskList" data-uid="${item.askUID}" onclick="viewAsk(this)">
							<div class="admin_AskListItem_Num">${totalcount}</div>
							<div class="admin_AskListItem_Category">${item.category}</div>
							<div class="admin_AskListItem_Subject">${item.subject}</div>
							<div class="admin_AskListItem_UserEmail">${item.userEmail}</div>
							<div class="admin_AskListItem_FeedBack">${item.active == 1 ? "미답변": item.active == 2 ? "읽음":"답변완료"}</div>
						</div>`;
						totalcount--;
					}
					document.getElementById('admin_AskBorder').innerHTML = result;
					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	