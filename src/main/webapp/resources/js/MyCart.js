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
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	