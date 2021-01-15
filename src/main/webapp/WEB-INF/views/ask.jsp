<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/ask.css">
	<div class="ask">
		<div><h1>질문답변</h1></div>
		<div class="askBorder">
			<div class="askBorderLeft">
				<div class="borderTop">자주하는질문</div>
				<div class="leftItem">
					<div>코가 자꾸 늘었다줄어들어요</div>
				</div>
			</div>
			<div class="askBorderRight">
				<div class="borderTop">질문남기기</div>
				<div class="askInputBorder">
					<div class="inputItem">
						<div class="inputText">제목</div>
						<div class="inputValue"><input id="subject" placeholder="SubJect"></div>
					</div>
					<div class="inputItem">
						<div class="inputText">분류</div>
						<div class="inputValue">
							<select id="categorySelect">
								<option>분류</option>
								<option>분류1</option>
								<option>분류2</option>
								<option>기타</option>
							</select>
						</div>
					</div>
					<div class="inputItem">
						<div class="inputText">연락처</div>
						<div class="inputValue"><input id="phoneNumber" placeholder="Phone_Number"></div>
					</div>
					<div class="inputItem">
						<div class="inputText">이메일</div>
						<div class="inputValueEmail">			
							<div><input id="email1" placeholder="Email"></div>
							<div style="align-self: center; margin: 2px;">@</div>
							<div><input id="email2" placeholder="Address"></div>
							<div class="emailSelect">
								<select>
									<option>네이버</option>
									<option>구글</option>
									<option>다음</option>
								</select>
							</div>
						</div>
					</div>
					<div class="inputTextarea">
						<div class="borderTop">질문하실 내용</div>
						<div><textarea id="content"></textarea></div>
						<div style="margin: 8px;"><input type="file" id="inputfile"></div>
						<div class="terms">
							<p>
							1. 개인정보의 수집 및 이용목적 회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다. 
제보 민원처리 및 결과회신 ※ 귀하께서는 귀하의 개인정보 수집 · 
이용에 대한 동의를 거부하실 권리가 있으며 다만, 동의를 거부하실 경우, 
제보 민원을 적시에 처리하지 못할 수 있습니다. 
							</p>
							<p>
							2. 수집하는 개인정보 항목 윤리경영을 위해 아래와 같은 개인정보를 수집하고 있습니다. 
필수사항 : 제보유형, 성명, 연락처(전화번호), 이메일 주소, 제목 , 내용 
							</p>
							<p>
							3. 개인정보의 보유 및 이용기간 
* 보유 기간 : 제보 문의 처리 후 5년 
* 보유 근거 : 회사 내부 방침 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 
단, 관련 법령의 규정에 의하여 보존할 의무가 있는 경우에는 법령이 지정한 일정기간 보존합니다.
							</p>
						</div>
						<div style="margin-top: 13px;"><input type="checkbox"><span>(필수) 개인정보 보호를 위한 이용자 동의 사항에 동의힙니다.
</span></div>
						<div class="submitButton"><input id="sendButton" type="button" value="글 전송하기"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/askSystem.js"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		


