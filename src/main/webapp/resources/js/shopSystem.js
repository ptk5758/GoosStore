/**
 * 
 */


	/*미드카테불러오기*/	
	function getCategory(select,seller){
		$(function(){
			$.ajax({
				type: "GET", 
				url:"/shopList/bottomCategory",  
				data:"select="+select+"&seller="+seller,
				contentType: "application/json; charset=utf-8",
				success : function(data){
					var jsondata = JSON.parse(data);
					console.log(jsondata);
					console.log(jsondata.category[0]);
					console.log(jsondata.category.length)
					var str = "";
					str += `
					<ul>
					<li onclick="getemAll('${select}','${seller}')">전체</li>
					</ul>`;
					for(var i=0; i<jsondata.category.length; i++){
					
						str += `
						<ul>
							<li onclick="getMidCategory('${jsondata.category[i]}','${seller}')"'>${jsondata.category[i]}</li>
						</ul`;
					}
					$(".midcatBorder_Left").html(str);
					
					getemAll(select,seller);
				},
				error : function(error) {
		        }
			});
		});
	}

	
	function getemAll(select,seller,nowpage){
				var nowPage="";
			if(nowpage == null || nowpage == ""){
				nowPage = "1";
			}else{
				nowPage = nowpage;
			}
		$(function(){
			$.ajax({
				type:"GET",
				url:"/shopList/getShopList",
				data:"select="+select+"&seller="+seller+"&nowPage="+nowPage,
				contentType:"application/json; charset=utf-8",
				success:function(data){
					var jsondata = JSON.parse(data);
					
					var showPage = 4; //보여지는페이지
					var nowPage=1; //현재페이지
				
					var firstLimitPage; //첫번쨰리미트 페이지
					var totalPage;
					var totalList = jsondata.item.length; //전체리스트
					if(totalList%showPage == 0){
						totalPage = parseInt(totalList/showPage);
					}else{
						totalPage = parseInt(totalList/showPage) + 1; 
					}
					
					 //전체페이지
					var block = 3;
					var blockCount;
					if(totalPage/block == 0){
						blockCount = parseInt(totalPage/block);
					}else{
						blockCount = parseInt(totalPage/block) + 1;
					}
					var nowblock;
					if(nowPage%block == 0){
						nowblock = parseInt(nowPage/block);
					}else{
						nowblock = parseInt(nowPage/block) + 1;
					}
					var startPage = (nowblock-1)*block+1; //시작페이지
					var endPage = nowblock*block;
					
					if(endPage>totalPage){
						endPage = totalPage;
					}
					
					var str="";
					for(var i=0;i<jsondata.item.length;i++){
						list = jsondata.item[i].itemName;
						list1 =  jsondata.item[i].itemPrice;
						list2 =  jsondata.item[i].img_m;
						str += `<div class="itemInfo">
									<div class="itemImg"><img src="/upload/${list2}" width="150" height="200"></div>
									<div class="itemName">${list}</div>
									<div class="itemPrice">${list1}</div>
								  </div>`;						
					}
					$(".midcatBorder_Right").html(str);
					var pagestr="";
				if(startPage > block){
					nowPage = startPage - block;
					pagestr +=`<span class="Previous" onclick='getemAll("`+select+`","${seller}","`+nowPage+`")'></span>`
				}		
				for(var i=startPage;i<=endPage;i++){
								pagestr +=`<div class="page" style='cursor:pointer;' onclick='getemAll("`+select+`","${seller}", "`+i+`")'>`+i+`</div>`
							}
				if(endPage < totalPage){
					nowPage = endPage + 1;
					pagestr +=`<span class="Next"  onclick='getemAll("`+select+`","${seller}","`+nowPage+`")'></span>`
				}
				$(".midcatBorder_Right").append(pagestr);
				},
				error:function(){
				}
			})
		})
	}
		/*바텀카테불러오기*/
		function getMidCategory(select,seller,nowpage){
			var nowPage="";
			if(nowpage == null || nowpage == ""){
				nowPage = "1";
			}else{
				nowPage = nowpage;
			}
			$(function(){
				$.ajax({
					type:"GET",
					url:"/shopList/Category",
					data:"select="+select+"&seller="+seller+"&nowPage="+nowPage,
					contentType:"application/json; charset=utf-8",
					success:function(data){
					var jsondata = JSON.parse(data);
					
					var showPage = 4; //보여지는페이지
					var nowPage=1; //현재페이지
				
					var firstLimitPage; //첫번쨰리미트 페이지
					var totalPage;
					var totalList = jsondata.Categoryitem.length; //전체리스트
					if(totalList%showPage == 0){
						totalPage = parseInt(totalList/showPage);
					}else{
						totalPage = parseInt(totalList/showPage) + 1; 
					}
					
					 //전체페이지
					var block = 3;
					var blockCount;
					if(totalPage/block == 0){
						blockCount = parseInt(totalPage/block);
					}else{
						blockCount = parseInt(totalPage/block) + 1;
					}
					var nowblock;
					if(nowPage%block == 0){
						nowblock = parseInt(nowPage/block);
					}else{
						nowblock = parseInt(nowPage/block) + 1;
					}
					var startPage = (nowblock-1)*block+1; //시작페이지
					var endPage = nowblock*block;
					if(endPage>totalPage){
						endPage = totalPage;
					}
					
					var str="";
					for(var i=0;i<jsondata.Categoryitem.length;i++){	
						list = jsondata.Categoryitem[i].itemName
						list1 = jsondata.Categoryitem[i].itemPrice
						list2 = jsondata.Categoryitem[i].img_m
						uid = jsondata.Categoryitem[i].itemuid;
								str += `<div class="itemInfo">
											  <div class="itemImg"  onclick="location.href='/shop/itemview?itemuid=${uid}'"><img src="/upload/${list2}" width="150" height="200">	</div>
											  <div class="itemName">${list}</div>
											  <div class="itemPrice">${list1}</div>
										  </div>`;
					}
					$(".midcatBorder_Right").html(str);
					var pagestr="";
				if(startPage > block){
					nowPage = startPage - block;
					pagestr +=`<span class="Previous" onclick='getMidCategory("`+nowPage+`")'></span>`
				}		
				for(var i=startPage;i<=endPage;i++){
								pagestr +=`<div style='cursor:pointer;' onclick='getMidCategory("${seller}", "`+i+`")'>`+i+`</div>`
							}
				if(endPage < totalPage){
					nowPage = endPage + 1;
					pagestr +=`<span class="Next"  onclick='getMidCategory("`+nowPage+`")'></span>`
				}
				$(".midcatBorder_Right").append(pagestr);
					}
					
				})
			})
		}
		
		/*전체불러오기*/
		function getAllitemList(seller, nowpage){
			var nowPage="";
			if(nowpage == null || nowpage == ""){
				nowPage = "1";
			}else{
				nowPage = nowpage;
			}
			$(function(){
				$.ajax({
					url:"/shopList/GetAllList",
					data:"seller="+seller+"&nowPage="+nowPage , 
					contentType:"application/json; charset=utf-8",
					success:function(data){
						var jsondata = JSON.parse(data);
						
							var showPage = 4; //보여지는페이지
						
							var firstLimitPage; //첫번쨰리미트 페이지 
							var totalPage;
							var totalList = jsondata.getAll[0].count; //전체리스트
							console.log("===="+totalList);
							if(totalList%showPage == 0){
								totalPage = parseInt(totalList/showPage);
							}else{
								totalPage = parseInt(totalList/showPage) + 1; 
							}
							
							 //전체페이지
							var block = 3;
							var blockCount;
							if(totalPage/block == 0){
								blockCount = parseInt(totalPage/block);
							}else{
								blockCount = parseInt(totalPage/block) + 1;
							}
							var nowblock;
							if(nowPage%block == 0){
								nowblock = parseInt(nowPage/block);
							}else{
								nowblock = parseInt(nowPage/block) + 1;
							}
							var startPage = (nowblock-1)*block+1; //시작페이지
							var endPage = nowblock*block;
							if(endPage>totalPage){
								endPage = totalPage;
							}
							
							var str="";
							for(var i=0;i<jsondata.getAll.length;i++){
						
							list1 = jsondata.getAll[i].itemName;
							list2= jsondata.getAll[i].itemPrice;
							list3 = jsondata.getAll[i].img_m;
							uid = jsondata.getAll[i].itemuid;
							
							str += `<div class="itemInfo">
											  <div class="itemImg"  onclick="location.href='/shop/itemview?itemuid=${uid}'"><img src="/upload/${list3}" width="150" height="200"></div>
											  <div class="itemName">${list1}</div>
											  <div class="itemPrice">${list2}</div>
										  </div>`;
						}
					
						$(".midcatBorder_Right").html(str);
						getallcatlist(seller);
						var pagestr="";
						/*var seller_data = "${seller}";*/
						if(startPage > block){
							nowPage = startPage - block;
							pagestr +=`<span class='Previous' onclick='getAllitemList("`+nowPage+`")'></span>`
						}		
						for(var i=startPage;i<=endPage;i++){
								pagestr +=`<div style='cursor:pointer;' onclick='getAllitemList("${seller}", "`+i+`")'>`+i+`</div>`
							}
						if(endPage < totalPage){
							nowPage = endPage + 1;
							pagestr +=`<span class='Next' onclick='getAllitemList("`+nowPage+`")'></span>`
						}
					$(".midcatBorder_Right").append(pagestr);
					},
					error:function(){
					}
				})
			})
		}
	var getallcatlist =	function getallcategory(seller){
			$(function(){
				$.ajax({
					url:"/shopList/getAllCategory",
					data:"seller="+seller,
					contentType:"application/json; charset=utf-8",
					success:function(data){
						var jsondata = JSON.parse(data);
						var str="";
						for(var i=0; i<jsondata.AllCategory.length; i++){
						str += `
						<div onclick="getMidCategory('${jsondata.AllCategory[i]}','${seller}')">${jsondata.AllCategory[i]}
						</div>`;
					}
					$(".midcatBorder_Left").html(str);
					},
					error:function(){
					}
				})	
			})
		}
			var price = function changePrice(result,uid){
				$(function(){
					$.ajax({
						url:"/shopList/changePrice",
						contentType:"application/json",
						data:"result="+result+"&uid="+uid,
						success:function(data){
							var jsondata = JSON.parse(data);
							var str="";
							str +=`가격:${jsondata*result}`;
							$(".itemPrice").html(str);
						},
						error:function(){
							
						}
					})
				})
			}
			var count=1;
			document.getElementById("count")
			function plus(uid){
				count++;
				document.getElementById("count").value = count;
				var result = document.getElementById("count").value = count;
				price(result,uid);
			}
			function minus(uid){
				if(count>1){
					count--;
					var result = document.getElementById("count").value = count;
					price(result,uid);
				}
			}
			
		
	
			
			
			