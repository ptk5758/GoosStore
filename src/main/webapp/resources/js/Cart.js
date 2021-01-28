/**
 * 
 */

	console.log("hello cart");
	
	let cartIn = (itemuid, userid) => {
		let itemcount = document.getElementById('cartCount').innerHTML;
		if(userid === ""){
			alert("장바구니는 로그인을 하신후에 사용하실수있습니다.");
			return;
		}
		console.log(itemuid);
		console.log(userid);
		let formData = new FormData();
		formData.set("itemUID", itemuid);
		formData.set("userID", userid);
		formData.set("itemCount", parseInt(itemcount));
		
		let xhp = new XMLHttpRequest();
		xhp.open("POST","/Cart/", true);
		xhp.send(formData);
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				console.log(JSON.parse(xhp.responseText));
				if(JSON.parse(xhp.responseText).msg === "실패"){
					alert(JSON.parse(xhp.responseText).comment);
					return;
				}
				alert("장바구니에 추가되었습니다.");
				document.getElementById('BTS').innerHTML=`<button>등록성공</button>`;
				
			}
		}
	}
	
	let cartCount = (value) => {
		let x = document.getElementById('cartCount').innerHTML;
		if(x <= 0){
			alert("1 개 이상만 구매 가능합니다.");
			document.getElementById('cartCount').innerHTML = 1;
			/*history.back();*/
			return;
		}
		document.getElementById('cartCount').innerHTML = parseInt(x)+value;
	}