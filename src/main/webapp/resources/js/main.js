/**
 * 이곳은 공통적으로 들어가는 javascript 파일입니다.
 */
	console.log("hello world");
	$(document).ready(function(){
		$('#mainColor1').change(function(){
			var colorValue1 = $('#mainColor1').val();
			var colorValue2 = $('#mainColor2').val();
			$('body').css("background","linear-gradient("+colorValue1+","+colorValue2+")");
		});
		$('#mainColor2').change(function(){
			var colorValue1 = $('#mainColor1').val();
			var colorValue2 = $('#mainColor2').val();
			$('body').css("background","linear-gradient("+colorValue1+","+colorValue2+")");
		});
	});

