/**
 * 
 */

	$(document).ready(function(){
		console.log("gdgd");
		
		let result = "";
		$.ajax({
			url : "/restAttend/backDate",
			Type : "GET",
			dataType : "json",
			success : function(backdate){				
				let backDateData = backdate.backDate;
				for(let j=backDateData.length-1; j>=0; j--){
					result += `<div class="selectDateItem">
											<div class="dateMonth">${backDateData[j].MONTH_ENG}</div>
											<div class="dateDate">
												<div><b>${backDateData[j].DAY_OF_WEEK}</b></div>
												<div>${backDateData[j].day}</div>
											</div>
								</div>`;
				}
				console.log("backdate");
				console.log(backDateData);
				console.log(backDateData[0].day);
				
				$.ajax({
					url : "/restAttend/getDate",
					Type : "GET",
					dataType : "json",
					success : function(data){
						console.log(data);
						let jsondata = data.date;
						console.log(jsondata);
						
						$('.selectDate').html("");
						for(let i=0; i<jsondata.length; i++){
							result += `<div class="selectDateItem">
											<div class="dateMonth">${jsondata[i].MONTH_ENG}</div>
											<div class="dateDate">
												<div><b>${jsondata[i].DAY_OF_WEEK}</b></div>
												<div>${jsondata[i].day}</div>
											</div>
										</div>`;
						}
						$('.selectDate').html(result);
					},
					error : function(error){
						console.log(error);
					}
				});
			},
			error : function(error){
				console.log(error);
			}
		});
	});