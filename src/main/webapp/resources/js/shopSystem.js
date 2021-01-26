/**
 * #Test
 */
	let getSeller = () => {
		let xhp = new XMLHttpRequest();
		xhp.open("GET", "/shop/Seller" ,true);
		xhp.send(null);
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				let jsonData = JSON.parse(xhp.responseText);
				console.log(jsonData);
				let lists = jsonData.list;
				let defaultTable = document.getElementById('shopcontainer');
				let result = "";
				for(let list of lists){
					result += `
						<div class="BJ" data-sellerID="${list.ID}" data-name="${list.name}">
							<div class="BJ_IMG">
								<img src="${list.img}">
							</div>
							<div class="BJ_Text">
							</div>
						</div>
					`;
				}
				defaultTable.innerHTML = result;
			}
		}
	}
	getSeller();