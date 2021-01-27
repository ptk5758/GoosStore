<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css?ver=1">
	<div class="sellerborder">
		<div class="sellerborder_top">셀러 수정</div>
		<div class="sellerborder_input">
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">1</div>
				</div>
				<div class="input_item_text">셀러명</div>
				<div class="input_item_input"><input id="SellerName" placeholder="SellerName" value="${user.name}"></div>
				<div class="input_item_option"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">2</div>
				</div>
				<div class="input_item_text">아이디</div>
				<div class="input_item_input"><input id="SellerID" placeholder="SellerID" value="${user.sellerID}" readonly="readonly"></div>
				<div class="input_item_option"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">3</div>
				</div>				
				<div class="input_item_text">대표전화</div>
				<div class="input_item_input"><input id="SellerNumber" placeholder="SellerNumber" value="${user.phone}"></div>
				<div class="input_item_option"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">4</div>
				</div>
				<div class="input_item_text">우편번호</div>
				<div class="input_item_input"><input type="text" id="sample6_postcode" placeholder="우편번호" value="${user.postcod}"></div>
				<div class="input_item_option"><input id="addrBth" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 검색"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">5</div>
				</div>
				<div class="input_item_text">주소</div>
				<div class="input_item_input"><input type="text" id="sample6_address" placeholder="주소" value="${user.addr1}"></div>
				<div class="input_item_option input_item_input"><input type="text" id="sample6_detailAddress" placeholder="상세주소" value="${user.addr2}"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">6</div>
				</div>
				<div class="input_item_text">한줄코맨트</div>
				<div class="input_item_input"><input type="text" id="comment" value="${user.comment}"></div>
				<div class="input_item_option"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">7</div>
				</div>
				<div class="input_item_text">프로필 사진</div>
				<div class="input_item_input"><input type="file" id="profile"></div>
				<div class="input_item_option"></div>
			</div>
			<div class="sellerborder_input_item">
				<div class="input_item_num">
					<div class="circle">8</div>
				</div>
				<div class="input_item_text"></div>
				<div class="input_item_input"><button id="sellerSubmit">수정하기</button></div>
				<div class="input_item_option"></div>
			</div>
		</div>
	</div>
<script src="/js/sellerModify.js?ver=1"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    //document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    //document.getElementById("sample6_extraAddress").value = '';
                    console.log("gdgd");
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>