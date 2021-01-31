/**
 * 
 */

	let getMyItem = () => {
		let promise = new Promise((resolve, reject) => {
			
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/Shopapi/GetShopItemList?userID="+sessionStorage.getItem('sessionID'), true);
			xhp.send(null);
			
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					resolve(JSON.parse(xhp.responseText));
				}
			}
			
		});
		
		promise.then((res) => {
			//document.getElementById('MyShopBorder').innerHTML;
			console.log(res);
			let count = res.count;
			result = "";
			for(let item of res.list){
				result += `
					<div class="MyShop_Item" onclick="viewItem('${item.UserID}','${item.itemUID}')">
						<div class="MyShop_Item_Num">${count}</div>
						<div class="MyShop_Item_Thum"><img src=${item.img_m}></div>
						<div class="MyShop_Item_Name">${item.itemName}</div>
						<div class="MyShop_Item_Price">${item.itemPrice}</div>
						<div class="MyShop_Item_Date">${item.signdate}</div>
					</div>
				`;
				count--;
			}
			document.getElementById('MyShopBorder').innerHTML += result;
		});
	}
	
	let viewItem = (userID, uid) => {
		location.href=`/shop/${userID}/${uid}`;
	}
	
	getMyItem();