/**
 * 
 */
	console.log("아");
	
	let getShopList = () => {
		let promise = new Promise((resolve,reject) => {
			
			let xhp = new XMLHttpRequest();
			xhp.open("GET", "/Shopapi/GetShopList", true);
			xhp.send(null);
			
			xhp.onreadystatechange = () => {
				if(xhp.readyState === 4 && xhp.status === 200){
					resolve(JSON.parse(xhp.responseText));
				}
			}
			
		});
		
		promise.then((res) => {
			console.log(res);
			
			let result = "<div class='admin_AskListBorder'>";
				result += `
					<div class="admin_searchOption">
						<div>
							<select onchange="viewLimit(this)">
								<option>All</option>
								<option>5</option>
								<option>10</option>								
							</select>
						</div>
						<div>
							<select>
								<option>카테고리 선택</option>
								<option>기타</option>
								<option>채용문의</option>
								<option>상품문의</option>
								<option>기능문의</option>								
							</select>
						</div>
						<div>
							<input placeholder="제목">
						</div>
						<div>
							<button>검색하기</button>
						</div>
					</div>
					<div id="admin_AskBorder">
				`;
				let jsondata = res.list;
				let count = res.count;
				for(let item of jsondata){
					result += `
						<div class="admin_AskList" data-uid="${item.itemUID}" onclick="viewShopItem(this)">
							<div class="admin_AskListItem_Num">${count}</div>
							<div class="admin_AskListItem_Category">${item.itemMidCategory}</div>
							<div class="admin_AskListItem_Subject">${item.itemName}</div>
							<div class="admin_AskListItem_UserEmail">${item.user}</div>
							<div class="admin_AskListItem_FeedBack">${item.signdate.substring(0,10)}</div>
						</div>`;
						count--;
				}
				result += "</div></div>";
				$('.adminContent').html(result);
		});
	}
	
	let viewShopItem = (item) => {
		console.log("fdfd");
	}