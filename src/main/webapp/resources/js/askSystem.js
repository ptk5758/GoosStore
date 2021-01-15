/**
 * 
 */

	console.log("hello JavaScript");
	
	let uploadButton = document.getElementById('sendButton');
	let requestFile = document.getElementById('inputfile');
	uploadButton.addEventListener("click", function(){
		
		let formData = new FormData();
		let subjectData = document.getElementById('subject').value;
		let categorySelect = document.getElementById('categorySelect').value;
		let phoneNumber = document.getElementById('phoneNumber').value;
		
		formData.append("subject", subjectData);
		formData.append("category", categorySelect);
		formData.append("phone", phoneNumber);
		for(let file of requestFile.files){
			formData.append("file", file);
		}
		
		let xhp = new XMLHttpRequest();
		xhp.open("POST", "", true);
	});