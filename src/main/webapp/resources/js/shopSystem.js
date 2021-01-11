/**
 * 
 */

	function getCategory(select){
		console.log(select)
		$(function(){
			$.ajax({
				type: "GET",
				url:"/shopList/bottomCategory",
				data: "select="+select,
				contentType: "application/json; charset=utf-8",
				success : function(data){
					var jsondata = JSON.parse(data);
					console.log(jsondata);
					console.log(jsondata.cateGory[0]);
					console.log(jsondata.cateGory.length)
					var str = "";
					for(var i=0; i<jsondata.cateGory.length; i++){
						var item = jsondata.cateGory[i];
						str += `<div onclick="getItemList('${item}')">${jsondata.cateGory[i]}</div>`;
					}
					$(".midcatBorder_Left").html(str);
					console.log(str);
					showList(select);
				},
				error : function(error) {
		        	console.log(error);
		        }
			});
		});
	}
	
	var showList = function(select){
		$(function(){
			$.ajax({
				type: "GET",
				url: "/shopList/getShopList",
				data: "select="+select,
				contentType: "application/json; charset=utf-8",
				success: function(data){
					if(data != ""){
						var jsondata = JSON.parse(data);
						var shopArray = jsondata.item;
						console.log(shopArray);
						var result = "";
						for(var i=0; i<shopArray.length; i++){
							var str = `<div class="shopListItem" onclick="viewItem('${shopArray[i].itemUID}')">
											<div><img width="150" height="150" src="/img/woo.jpg"></div>
											<div>${shopArray[i].itemName}</div>
											<div>${shopArray[i].itemPrice}</div>
										</div>`;
							result += str;
						}
						$('.midcatBorder_Right').html(result);
					}else{
						alert("아직상품이없습니다.");
					}
					
				
				},
				error : function(error){
					console.log(error)
				}
			});
		});
	}
	
	function getItemList(item){
		$(function(){
			$.ajax({
				type : "GET",
				url : "/shopList/getItemList",
				data : "select="+item,
				contentType : "application/json; charset=UTF-8",
				success : function(data){
					if(data != ""){
						var jsondata = JSON.parse(data);
						var shopArray = jsondata.items;
						console.log(shopArray);
						var result = "";
						for(var i=0; i<shopArray.length; i++){
							var str = `<div class="shopListItem" onclick="viewItem('${shopArray[i].itemUID}')">
											<div><img width="150" height="150" src="/img/woo.jpg"></div>
											<div>${shopArray[i].itemName}</div>
											<div>${shopArray[i].itemPrice}</div>
										</div>`;
							result += str;
						}
						$('.midcatBorder_Right').html(result);
					}else{
						alert("아직상품이없습니다.");
					}
				},
				error : function(error){
					alert("연결실패");
				}
			});
		});
	}
	
	function viewItem(uid){
		location.href="/shop/viewItem?itemUID="+uid;
	}
	