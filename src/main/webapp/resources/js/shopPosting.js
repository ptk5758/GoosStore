/**
 *  #절대까먹지말자 
 *  파일 미리보기 얘시
 *	pr event Default 프리 이벤트 디폴트
 *	####this, event 차이 명확함 까먹지말것
 */
	console.log("gdgd");
	
	let viewimg = (event) => {
		console.log(event);
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
	
	$(function(){
		$('.posting_border_left').on("dragover",(event)=>{
			event.preventDefault();
			console.log("drag");
			/*$('.posting_border_left').css("border","5px solid blue");*/
		});
		$('.posting_border_left').on("drop",function(event){
			event.preventDefault();
			let files = event.originalEvent.dataTransfer.files;
			let fileElement = document.getElementById('mainimg');
			fileElement.files = files;
		});
	})
	
	let postingdo = () => {
		let myform = document.getElementById('itemform');
		let formData = new FormData(myform);
		let xhp = new XMLHttpRequest();
		let img = document.getElementById('mainimg');
		let imgs = document.getElementById('imgs');
		let inputcontent = document.getElementById('inputcontent').value;
		formData.append("itemContent", inputcontent);
		formData.append("mainimg",img.files[0]);
		for(let file of imgs.files){
			formData.append("imgs", file);
		}
		xhp.open("POST","/shop/posting",true);
		xhp.send(formData);
		
		
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
	