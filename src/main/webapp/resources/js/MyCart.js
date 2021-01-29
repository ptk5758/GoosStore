/**
 * 
 */
	
	let sessionID = sessionStorage.getItem("sessionID");
	
	let cartpageload = () => {
		
		if(sessionID != null || sessionID === ""){
		//장바구니를 가져오는 함수
		let promise = new Promise((resolve, reject)=>{
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/Cartapi/ListGet?userID="+sessionID, true);
			xhp.send(null);
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					resolve(JSON.parse(xhp.responseText));
				}
			};
		});
		
		promise.then((res) => {
			console.log(res);
			let cart = document.getElementById('myCart');
			let num = res.count;
			let list = res.list;
			let result = `
				<div class="Cart_Border">
					<div class="Cart_Item">
						<div class="Cart_Num Cart_Top">번호</div>
						<div class="Cart_Thum Cart_Top">썸네일</div>
						<div class="Cart_Subject Cart_Top">상품이름</div>
						<div class="Cart_Price Cart_Top">가격</div>
						<div class="Cart_TotalPrice Cart_Top">총가격</div>
						<div class="Cart_Check Cart_Top">체크</div>
					</div>
			`;
			for(let item of list){
				let shopitem = item.shopItem[0];
				result += `
					<div class="Cart_Item">
						<div class="Cart_Num">${num}</div>
						<div class="Cart_Thum"><img src="${shopitem.img_m}"></div>
						<div class="Cart_Subject">${shopitem.itemName}</div>
						<div class="Cart_Price">${shopitem.itemPrice} 원</div>
						<div class="Cart_TotalPrice">${shopitem.itemPrice} 원 X ${item.itemcount} 개 = ${shopitem.itemPrice * item.itemcount} 원</div>
						<div class="Cart_Check"><input id="check" type="checkbox" value="${shopitem.itemPrice * item.itemcount}" onchange="itemCheck()" data-uid="${item.cartuid}"></div>
					</div>
				`;-
				num--;
			}
			result += `</div>`;
			cart.innerHTML = result;
		});
	}
	
	
	
	}
	
	
	// x:y x 가 y 인것
	// ex input:checkbox 인푸시 checkbox 인것 : checked : 중에 checked 인것
	let itemCheck = () => {
		$(function(){
			let checkboxs = $("input:checkbox[id='check']:checked");
			let result = 0;
			for(let checkItem of checkboxs){
				console.log(checkItem.getAttribute('data-uid'));
				result += parseInt(checkItem.value);
			}
			document.getElementById('totalPrice').innerHTML = result+" 원";
		})
	}
	
	let deleteCartItem = () => {
		$(function(){
			
			let checkboxs = $('input:checkbox[id="check"]:checked');
			let resultArray = new Array();
			
			for(let item of checkboxs){
				resultArray.push(item.getAttribute('data-uid'));
			}
			
			let promise2 = new Promise((resolve, reject) => {
				resolve(resultArray);
			})
			
			promise2.then((res) => {
				
				for(let item of res){
					let requestData = {cartUID:item, userID:sessionStorage.getItem('sessionID')};
					let xhp = new XMLHttpRequest();
					xhp.open("DELETE", "/Cartapi/ListDelete/"+item, true);
					xhp.send(null);
				}
				alert("성공");
				cartpageload();
			});
		});		
	}
	
	cartpageload();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	