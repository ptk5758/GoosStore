/**
 * 
 */

	$(document).ready(function(){
		console.log("gdgd");
		$.ajax({
			url : "/restAttend/getDate",
			Type : "GET",
			dataType : "json",
			success : function(data){
				console.log(data);
				let jsondata = data.date;
				console.log(jsondata);
				let result = "";
				$('.selectDate').html("");
				for(let i=0; i<jsondata.length; i++){
					result += `<div class="selectDateItem">
									<div class="dateMonth">${jsondata[i].MONTH_ENG}</div>
									<div class="dateDate">${jsondata[i].day}</div>
								</div>`;
				}
				$('.selectDate').html(result);
			},
			error : function(error){
				console.log(error);
			}
		});
	});