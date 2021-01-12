/**
 * 
 */

	$(document).ready(function(){
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
												<div style="color: ${backDateData[j].font_color}"><b>${backDateData[j].DAY_OF_WEEK}</b></div>
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
												<div style="color: ${jsondata[i].font_color}"><b>${jsondata[i].DAY_OF_WEEK}</b></div>
												<div>${jsondata[i].day}</div>
											</div>
										</div>`;
						}
						$('.selectDate').html(result);
						today();
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
	
	let today = function(){
		$(function(){
			let R = 200;
			let G = 200;
			let B = 255;
			$('.selectDate .selectDateItem:nth-child(3)').css("background-color",`rgb(${R},${G},${B})`);
			$('.selectDate .selectDateItem:nth-child(3)').html($('.selectDate .selectDateItem:nth-child(3)').html()+"<span class='today'>ToDay~</span>");
			for(let i=3; i<$('.selectDate .selectDateItem:nth-child(3)').nextAll().length+3; i++){
				$('.selectDate .selectDateItem:nth-child('+i+')').next().css("background-color",`rgb(${R},${G},${B})`);
				R += 15;
				G += 15;
			}
			R = 200;
			G = 200;
			B = 255;
			for(let i=3; i>=1; i--){
				$('.selectDate .selectDateItem:nth-child('+i+')').prev().css("background-color",`rgb(${R},${G},${B})`);
				R += 15;
				G += 15;
			}
		});
	}

	
	
	
	
	
	
	
	
	
	
	
	
	