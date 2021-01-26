/**
 *  #절대까먹지말자 
 *  파일 미리보기 얘시
 */

	
	$(document).ready(function(){
		$('.posting').on("dragover",(event)=>{
			event.preventDefault();
			console.log("drag hello");
		});
		$('.posting').on("drop", function(event){
			event.preventDefault();
			let files = event.originalEvent.dataTransfer.files;
			console.log(files);
			let reader = new FileReader();
			reader.onload = function(e){
				console.log(e);
				let result = `<img src="${e.target.result}">`;
				$('#image_container').html(result);
			}
			reader.readAsDataURL(files[0]);
		});
	})
	
	function setThumbnail(event) { 
		var reader = new FileReader();
		
		reader.onload = function(e) {
			console.log(e);
			var img = document.createElement("img");			
			img.setAttribute("src", e.target.result);
			document.querySelector("div#image_container").appendChild(img);			
		};
		reader.readAsDataURL(event.target.files[0]);
	}
	