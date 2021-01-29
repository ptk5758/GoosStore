/**
 * 
 */

	/*let sessionID = sessionStorage.getItem("sessionID");
	console.log("hello mycart");
	let xhp = new XMLHttpRequest();
	xhp.open("GET", "/Cartapi/ListGet?userID="+sessionID, true);
	xhp.send(null);
	xhp.onreadystatechange = () => {
		if(xhp.readyState === 4 && xhp.status === 200){
			let jsonData = JSON.parse(xhp.responseText);
			shopItemInit(jsonData);
		}
	}
	
	let shopItemInit = (receive) => {
		let list = receive.list;
		let item = new Array();
		for(let i=0; i<list.length; i++){
			item[i] = getShopItem(list[i].itemuid);
		}
		console.log(receive);
	}*/
	
	/*let promise = new Promise((resolve, reject) => {
		console.log("gdgd");
		let xhp = new XMLHttpRequest();
		xhp.open("GET", "/Cartapi/ListGet?userID="+sessionID, true);
		xhp.send(null);
		xhp.onreadystatechange = () => {
		if(xhp.readyState === 4 && xhp.status === 200){
			let jsonData = JSON.parse(xhp.responseText);
			resolve(jsonData);
		}
		
		}
	});
	promise.then((value) => {
		let list = value.list;
		let itemUID = new Array();
		console.log(list);
		for(let i=0; i<list.length; i++){
			itemUID[i] = list[i].itemuid;
		}
		let getShopItem = new Promise((res,rej) => {
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/Shopapi/GetShopItem?itemUID="+itemUID[0], true);
			xhp.send(null);
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					res(xhp.responseText);
				}
			}
		});
		
		getShopItem.then((res) => {
			console.log(res);
		});
	});*/
	
	let sessionID = sessionStorage.getItem("sessionID");
	
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
			let result = "";
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
				`;
				num--;
			}
			cart.innerHTML += result;
		});
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	