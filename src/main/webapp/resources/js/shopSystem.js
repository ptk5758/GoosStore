/**
 * 
 */

	function getCategory(){
		$(function(){
			$.ajax({
				type: "GET",
				url:"/shopList/bottomCategory",
				contentType: "application/json; charset=utf-8",
				success : function(data){
					var jsondata = JSON.parse(data);
					console.log(jsondata);
					console.log(jsondata.cateGory[0]);
					console.log(jsondata.cateGory.length)
					var str = "";
					for(var i=0; i<jsondata.cateGory.length; i++){
						str += `<div>${jsondata.cateGory[i]}</div>`;
					}
					$(".midcatBorder_Left").html(str);
					console.log(str);
				},
				error : function(error) {
		        	console.log(error);
		        }
			});
		});
	}