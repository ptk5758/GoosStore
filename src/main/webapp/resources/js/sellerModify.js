/**
 * 
 */
	let submitbth = document.getElementById('sellerSubmit');
	
	submitbth.addEventListener("click", function(){
		
		let userFile = document.getElementById('profile');
		if(userFile.files.length <= 0){
			alert("프로필 사진은 무조건 업로드해주셔야합니다.");
			return;
		}
		let sellerName = document.getElementById('SellerName').value;
		if(sellerName === "" || sellerName == null){
			alert("셀러명을 입력하여주세요");
			return;
		}
		let sellerID = document.getElementById('SellerID').value;
		if(sellerID === "" || sellerID == null){
			alert("셀러님의 아이디를 입력하여주세요");
			return;
		}
		let sellerNumber = document.getElementById('SellerNumber').value;
		if(sellerNumber === "" || sellerNumber == null){
			alert("대표 전화번호를 입력하여주세요");
			return;
		}
		let postcode = document.getElementById('sample6_postcode').value;
		if(postcode === "" || postcode == null){
			alert("우편 번호를 입력하여 주세요");
			return;
		}
		let addr1 = document.getElementById('sample6_address').value;
		if(addr1 === "" || addr1 == null){
			alert("주소를 입력하여주세요");
			return;
		}
		let addr2 = document.getElementById('sample6_detailAddress').value;
		let comment = document.getElementById('comment').value;
		let formData = new FormData();
		formData.append("name",sellerName);
		formData.append("sellerID",sellerID);
		formData.append("phone",sellerNumber);
		formData.append("postcod",postcode);
		formData.append("addr1",addr1);
		formData.append("addr2",addr2);
		formData.append("comment", comment);
		for(let file of userFile.files){
			formData.append("files", file);
			console.log(file);
		}
		let xhp = new XMLHttpRequest();
		xhp.open("POST","/shop/sellermodify",true);
		xhp.send(formData);
		
		xhp.onreadystatechange = () => {
			if(xhp.readyState === 4 && xhp.status === 200){
				let jsonData = JSON.parse(xhp.responseText);
				console.log(jsonData);
				if(jsonData.msg === "성공"){
					alert("셀러 등록에 성공하셨습니다.");
					location.href="/";
				}
			}
		}
	});
	