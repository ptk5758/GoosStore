/**
 *  #절대까먹지말자 
 *  파일 미리보기 얘시
 *	pr event Default 프리 이벤트 디폴트
 *	####this, event 차이 명확함 까먹지말것
 */
	console.log("gdgd");
	
	let viewimg = (event) => {
		console.log(event.target.files[0].type);
		let type = event.target.files[0].type.split("/");
		
		if(type[0] === "image"){
			console.log("옳은 타입");
		} else {
			alert("잘못된 파일형식입니다.");
			return;
		}
		let reader = new FileReader();
		reader.onload = function(e) {
			$(function(){
				let result = `<img src="${e.target.result}">`;
				$('.posting_item_img').html(result);
			})
		};
		reader.readAsDataURL(event.target.files[0]);
	}
	
	/*$(document).ready(function(){
		$('.posting').on("dragover",(event)=>{
			event.preventDefault();
			console.log("drag hello");
		});
		$('.posting').on("drop", function(event){
			event.preventDefault();
			let files = event.originalEvent.dataTransfer.files;
			console.log(files);
			let reader = new FileReader();
			reader.readAsDataURL(files[0]);
			reader.onload = function(e){
				console.log(e);
				let result = `<img src="${e.target.result}">`;
				$('.posting').html(result);
			}
			
		});
	})*/
	
	/*function setThumbnail(event) { 
		var reader = new FileReader();
		
		reader.onload = function(e) {
			console.log(e);
			var img = document.createElement("img");			
			img.setAttribute("src", e.target.result);
			document.querySelector("div#image_container").appendChild(img);			
		};
		reader.readAsDataURL(event.target.files[0]);
	}*/
	