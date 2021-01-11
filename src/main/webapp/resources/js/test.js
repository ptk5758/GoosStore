/**
 * 
 */

	
	$(document).ready(function(){
		$('.dragField').on('dragover dragenter', function(event){
			event.preventDefault();
			$('.dragField').css("border","1px solid#000000");
			console.log("drageOVER~~~~~");
		});
		$('.dragField').on('drop', function(event){
			event.preventDefault();
			let filelist = event.originalEvent.dataTransfer.files;
			let newimg = filelist[0];
			let reader = new FileReader();
			console.log(readURL(newimg));
			$('#testimg').attr("src","/img/승우아빠.jpg");
			console.log(newimg);
			console.log(filelist);
		});
	});
	
	/*dragover 파일을 가진체 드래그 하고있을경우 동작*/
	/*dragenter 파일을 가진체 드래그 하여 영역안에 들어온순간!*/
	/*event.originalEvent.dataTransfer.files 파일을 가져오는 함수*/  