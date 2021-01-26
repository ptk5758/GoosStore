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
						<div class="BJ" data-id="${list.ID}" data-name="${list.name}" onclick="viewItem(this)">
							<div class="BJ_IMG">
								<img src="${list.img}">
							</div>
							<div class="BJ_Text">
								<div>${list.comment}</div>
							</div>
						</div>
					`;
				}
				defaultTable.innerHTML = result;
			}
		}
	}
	getSeller();
	
	let viewItem = (item) => {
		$(function(){
			let sellerID = $(item).data('id');
			console.log(sellerID);
			location.href="/shop/"+sellerID;
		});
	}