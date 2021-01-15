/**
 * 
 */

	$(document).ready(function(){
		let result = "";
		console.log($('#nowYear').data('year'));/*---------------------------핵심-------------------------------------*/
		$.ajax({
			url : "/restAttend/backDate",
			Type : "GET",
			dataType : "json",
			success : function(backdate){				
				let backDateData = backdate.backDate;
				for(let j=backDateData.length-1; j>=0; j--){
					let itemDate = `${backDateData[j].year}-${("00"+backDateData[j].Month).slice(-2)}-${("00"+backDateData[j].day).slice(-2)}`;
					console.log(itemDate);
					result += `<div class="selectDateItem" data-date="${backDateData[j].year}-${("00"+backDateData[j].Month).slice(-2)}-${("00"+backDateData[j].day).slice(-2)}" onclick="selectAttend(this)">
											<div class="dateMonth">${backDateData[j].MONTH_ENG}</div>
											<div class="dateDate">
												<div style="color: ${backDateData[j].font_color}"><b>${backDateData[j].DAY_OF_WEEK}</b></div>
												<div>${backDateData[j].day}</div>
											</div>
											<div id="${itemDate}_Count" class="todayCheckMember">${backDateData[j].count}</div>
								</div>`;
				}				
				$.ajax({
					url : "/restAttend/getDate",
					Type : "GET",
					dataType : "json",
					success : function(data){
						let jsondata = data.date;						
						$('.selectDate').html("");
						for(let i=0; i<jsondata.length; i++){
							let itemDate = `${jsondata[i].year}-${("00"+jsondata[i].Month).slice(-2)}-${("00"+jsondata[i].day).slice(-2)}`;
							console.log(itemDate);
							result += `<div class="selectDateItem" data-date="${jsondata[i].year}-${("00"+jsondata[i].Month).slice(-2)}-${("00"+jsondata[i].day).slice(-2)}" onclick="selectAttend(this)">
											<div class="dateMonth">${jsondata[i].MONTH_ENG}</div>
											<div class="dateDate">
												<div style="color: ${jsondata[i].font_color}"><b>${jsondata[i].DAY_OF_WEEK}</b></div>
												<div>${jsondata[i].day}</div>
											</div>
											<div id="${itemDate}_Count" class="todayCheckMember">${jsondata[i].count}</div>
										</div>`;
						}
						$('.selectDate').html(result);						
						today();						
					},
					error : function(error){
						console.log(error);
					}
				});
			},
			error : function(error){
				console.log(error);
			}
		});
	});
	
	let today = function(){
		$(function(){
			let R = 200;
			let G = 200;
			let B = 255;
			$('.selectDate .selectDateItem:nth-child(3)').css({"background-color":`rgb(${R},${G},${B})`,"border":"3px solid #f9ff80"});
			for(let i=3; i<$('.selectDate .selectDateItem:nth-child(3)').nextAll().length+3; i++){
				$('.selectDate .selectDateItem:nth-child('+i+')').next().css("background-color",`rgb(${R},${G},${B})`);
				R += 15;
				G += 15;
			}
			R = 200;
			G = 200;
			B = 255;
			for(let i=3; i>=1; i--){
				$('.selectDate .selectDateItem:nth-child('+i+')').prev().css("background-color",`rgb(${R},${G},${B})`);
				R += 15;
				G += 15;
			}
		});
	}
	
	let attendInsert = function(sessionID, sessionNickName){
		console.log(sessionID,sessionNickName);
		let userID = sessionID;
		
		let userNickName = sessionNickName;
		let content = document.getElementById('content').value;
		let inputData = {userID:userID, userNickName:userNickName, content:content};
		console.log(inputData);
		$(function(){
			$.ajax({
				url: "/restAttend/attendInsert",
				type: "post",
				data: JSON.stringify(inputData),
				contentType: "application/json; charset=UTF-8",
				success : function(data){
					alert(data);
					getAttendList();
				},
				error : function(error){
					console.log(error);
				}
			});
		});
	}
	
	let getAttendList = function(){
		let today = new Date();
		let month = ("00"+(today.getMonth()+1).toString()).slice(-2);
		let day = ("00"+(today.getDate()).toString()).slice(-2);
		let defaultDate = `${today.getFullYear()}-${month}-${day}`;
		$(function(){
			$.ajax({
				url : "/restAttend/getAttendList",
				type : "get",
				data : "date="+defaultDate,
				dataType: "json",
				success : function(data){
					let attendlist = data.list;
					$('.attendList').html("");
					let result = "";					
					for(let i=0; i<attendlist.length; i++){
						let item = attendlist[i];
						result += `<div class="attendListItem">
										<div class="listUserINFO">
											<div class="userINFO_Level">Lv.${item.userLevel}</div>
											<div data-user="${item.userID}"><b>${item.userNickName}</b></div>
											<div class="UserINFO_date">${item.attendDate}</div>
											${sessionStorage.getItem('sessionID')===item.userID ? `<div onclick='attendcontentupdate("${item.attendUID}")'>수정</div><div onclick='attendcontentDelete("${item.attendUID}")'>삭제</div>`:``}
										</div>
										<div class="listContent">
											<p>${item.content}</p>
										</div>
									</div>`;
					}
					$('.attendList').html(result);
				},
				error : function(error){
					console.log(error);
				}
				
			});
		});
	}
	getAttendList();
	
	function selectAttend(selectDate){
		$(function(){
			let defaultDate = $(selectDate).data('date');
			$.ajax({
				url : "/restAttend/getAttendList",
				type : "get",
				data : "date="+defaultDate,
				dataType: "json",
				success : function(data){
					let attendlist = data.list;
					$('.attendList').html("");
					let result = "";					
					for(let i=0; i<attendlist.length; i++){
						let item = attendlist[i];
						result += `<div class="attendListItem">
										<div class="listUserINFO">
											<div class="userINFO_Level">Lv.${item.userLevel}</div>
											<div data-user="${item.userID}"><b>${item.userNickName}</b></div>
											<div class="UserINFO_date">${item.attendDate}</div>
											${sessionStorage.getItem('sessionID')===item.userID ? `<div onclick='attendcontentupdate("${item.attendUID}")'>수정</div><div onclick='attendcontentDelete("${item.attendUID}")'>삭제</div>`:``}
										</div>
										<div class="listContent">
											<p>${item.content}</p>
										</div>
									</div>`;
					}
					$('.attendList').html(result);
					backDate(defaultDate);
				},
				error : function(error){
					console.log(error);
				}
				
			});
		});
	}
	
	let backDate = function(selectdate){
		let result = "";
		$(function(){
			$.ajax({
					url : "/restAttend/backDate",
					Type : "GET",
					data : "date="+selectdate,
					dataType : "json",
					success : function(data){
						let jsondata = data.backDate;
						for(let i=jsondata.length-1; i>=0; i--){
							
							result += `<div class="selectDateItem" data-date="${jsondata[i].year}-${("00"+jsondata[i].Month).slice(-2)}-${("00"+jsondata[i].day).slice(-2)}" onclick="selectAttend(this)">
											<div class="dateMonth">${jsondata[i].MONTH_ENG}</div>
											<div class="dateDate">
												<div style="color: ${jsondata[i].font_color}"><b>${jsondata[i].DAY_OF_WEEK}</b></div>
												<div>${jsondata[i].day}</div>
											</div>
											<div class="todayCheckMember">${jsondata[i].count}</div>
										</div>`;
						}
						getDate(selectdate, result);
					},
					error : function(error){
						console.log(error);
					}
				});
		});
	}
	
	let getDate = function(selectdate, result){
		$(function(){
			$.ajax({
					url : "/restAttend/getDate",
					Type : "GET",
					data : "date="+selectdate,
					dataType : "json",
					success : function(data){
						let jsondata = data.date;
						for(let i=0; i<jsondata.length; i++){
							result += `<div class="selectDateItem" data-date="${jsondata[i].year}-${("00"+jsondata[i].Month).slice(-2)}-${("00"+jsondata[i].day).slice(-2)}" onclick="selectAttend(this)">
											<div class="dateMonth">${jsondata[i].MONTH_ENG}</div>
											<div class="dateDate">
												<div style="color: ${jsondata[i].font_color}"><b>${jsondata[i].DAY_OF_WEEK}</b></div>
												<div>${jsondata[i].day}</div>
											</div>
											<div class="todayCheckMember">${jsondata[i].count}</div>
										</div>`;
						}
						$('.selectDate').html(result);						
						today();
						console.log(jsondata);
					},
					error : function(error){
						console.log(error);
					}
				});
		});
	}
	
	function attendcontentupdate(attendUID){
		
		$(function(){
			$('.listContent').html(`
				<div class="attendUpdateElement">
					<input id="${attendUID}_Content" class="attendUpdateInput"><input type="button" value="수정하기" class="attendUpdateButton" onclick="attendUpdate('${attendUID}')">
				</div>`
			);
		});
	}
	
	let attendUpdate = function(attendUID){

		let newContent = document.getElementById(`${attendUID}_Content`).value;
		let requestData = {attendUID:attendUID, content:newContent}
		console.log(JSON.stringify(requestData));
		$(function(){
			$.ajax({
				url: "/restAttend/attendUpdate",
				type: "PATCH",
				dataType: "json",
				data: JSON.stringify(requestData),
				contentType: "application/json; charset=UTF-8",
				success: function(data){
					console.log(data.value);
					alert(data.msg);
					getAttendList();
				},
				error: function(error){
					console.log(error);
				}
			});
		});
	}
	
	let attendcontentDelete = function(attendUID){
		console.log(attendUID+"==================");
		
		let requestData = {attendUID:attendUID}
		console.log(JSON.stringify(requestData));
		$(function(){
			$.ajax({
				url: "/restAttend/attendDelete",
				type: "DELETE",
				dataType: "json",
				data: JSON.stringify(requestData),
				contentType: "application/json; charset=UTF-8",
				success: function(data){
					console.log(data);
					console.log(data.value);
					alert(data.msg);
					getAttendList();
				},
				error: function(error){
					console.log(error);
				}
			});
		});
	}
	
	let attendCount = function(date){
		return `${date}:PONG`;
	}
	
	
	
	
	
	
	
	
	
	
	
	