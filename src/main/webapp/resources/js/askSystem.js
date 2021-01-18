/**
 * 
 */

	console.log("hello JavaScript");
	
	let uploadButton = document.getElementById('sendButton');
	let requestFile = document.getElementById('inputfile');
	uploadButton.addEventListener("click", function(){
		if(requestFile.files.length > 3){
			alert("파일은 3개까지 전송 가능합니다.");
			return;
		}
		let formData = new FormData();
		let subjectData = document.getElementById('subject').value;
		if(subjectData === ""){
			alert("제목을 입력하여주세요");
			return;	
		}
		let categorySelect = document.getElementById('categorySelect').value;
		let phoneNumber = document.getElementById('phoneNumber').value;
		if(phoneNumber === ""){
			alert("연락처를 입력하여주세요");
			return;	
		}
		let email1 = document.getElementById('email1').value;
		if(email1 === ""){
			alert("이메일을 입력하여주세요");
			return;	
		}
		let email2 = document.getElementById('email2').value;
		let Email = email1+"@"+email2;
		let defaultcontent = document.getElementById('content').value;
		if(defaultcontent === ""){
			alert("내용을 적어주세요");
			return;	
		}
		
		formData.append("subject", subjectData);
		formData.append("category", categorySelect);
		formData.append("phone", phoneNumber);
		formData.append("userEmail", Email);
		formData.append("content", defaultcontent);
		for(let file of requestFile.files){
			formData.append("file", file);
		}
		$(function(){
				if($('input[type=checkbox]').is(":checked")){
				let xhp = new XMLHttpRequest();
				xhp.open("POST", "/RestAsk/", true);
				xhp.send(formData);
				alert("접수가 완료되었습니다.");
				getAskList();				
			} else {
				alert("약관에 동의해주시길 바랍니다.");
				return;
			}
		});
		
	});
	
	
	/*-------------------------------파일 드롭다운--------------------*/
	$(document).ready(function(){
		$(".askBorderRight").on("dragover",function(){
			console.log("드레그");
			$(".askBorderRight").css("border","border: 2px solid#c6f30e;");
		});
		$(".askBorderRight").on("drop",function(event){
			event.preventDefault();
			let files = event.originalEvent.dataTransfer.files;
			let requestFile = document.getElementById('inputfile');
			requestFile.files = files;
		});
	});
	
	$(function(){
		$('#emailSelect').change(function(){
			$('#email2').val($(this).val());
		});
	});
	
	/*-------------------------------자주 하는 질문 가져오기--------------------*/
	let getAskList = function(){
			$(function(){
			$.ajax({
			type : "GET",
			url : "/RestAsk/",
			dataType : "JSON",
			success : function(data){
				console.log(data);
				let jsonData = data.list;
				let result = "";
				for(let i=0; i<jsonData.length; i++){
					result += `<div class="leftItem" data-UID="${jsonData[i].askUID}">
								<div>${jsonData[i].subject}</div>
								</div>`;
				}
				$('.askBorderLeft').append(result);
			},
			error : function(error){
				console.log(error);
			}
			});
		});
	}
	getAskList();
	
	$(function(){
		$('#test').click(function(){
			console.log($('input[type=checkbox]').is(":checked"));
			if($('input[type=checkbox]').is(":checked")){
				alert("동의됌");
			} else {
				alert("동의안됌");
			}
		});
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	