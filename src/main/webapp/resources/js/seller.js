/**
 * 
 */
	let submitbth = document.getElementById('sellerSubmit');
	
	submitbth.addEventListener("click", function(){
		let userFile = document.getElementById('profile');
		let sellerName = document.getElementById('SellerName').value;
		let sellerID = document.getElementById('SellerID').value;
		let sellerNumber = document.getElementById('SellerNumber').value;
		let postcode = document.getElementById('sample6_postcode').value;
		let addr1 = document.getElementById('sample6_address').value;
		let addr2 = document.getElementById('sample6_detailAddress').value;
		console.log("SubMit!");
		console.log(sellerName);
		console.log(sellerID);
		console.log(postcode);
		console.log(addr1);
		console.log(addr2);
		console.log(userFile.files);
		console.log(sellerNumber);
		let formData = new FormData();
		formData.append("name",sellerName);
		formData.append("sellerID",sellerID);
		formData.append("phone",sellerNumber);
		formData.append("postcod",postcode);
		formData.append("addr1",addr1);
		formData.append("addr2",addr2);
		for(let file of userFile.files){
			formData.append("file",file);
		}
		let xhp = new XMLHttpRequest();
		xhp.open("POST","seller",true);
		xhp.send(formData);
		
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				console.log(xhp.responseText);
			}
		}
	});