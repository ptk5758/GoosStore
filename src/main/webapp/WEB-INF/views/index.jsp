<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div class="index">
		<div class="index_slide">
			<div class="index_slide_left">
				<span>
					<img src="/img/kain.png">
				</span>
			</div>
			<div class="index_slide_right">
				<div class="index_slide_right_item">
					<div class="index_icon_img">
						<img src="https://s3.marpple.co/files/u_1312391/2020/10/original/b80ef18fd043a21e5936d25aca9fd796d053bd891.jpeg">
					</div>
					<div class="index_icon_text">
						<div>
							현상수배 -보상금- -3000
						</div>
					</div>
				</div>
				<div class="index_slide_right_item">
					<div class="index_icon_img">
						<img src="https://s3.marpple.co/files/u_1312391/2020/10/original/e191b3cf2a554db3783b223d948520d008cd40841.jpeg">
					</div>
					<div class="index_icon_text">
						<div>
							케조씨 휴대폰 케이스
						</div>
					</div>
				</div>
				<div class="index_slide_right_item">
					<div class="index_icon_img">
						<img src="https://s3.marpple.co/files/u_1312391/2020/10/original/b07163c41d484a1c12847a454dfd789a1dd1f04f1.jpeg">
					</div>
					<div class="index_icon_text">
						<div>
							케조씨 그립톡
						</div>
					</div>
				</div>
				<div class="index_slide_right_item">
					<div class="index_icon_img">
						<img src="https://s3.marpple.co/files/u_1312391/2020/10/original/86b09d7a776e9a5468ad5f33d1728f0ea9a9fa4c1.jpeg">
					</div>
					<div class="index_icon_text">
						<div>
							노총각 마우스 장패드
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<c:if test="${sessionID != null }">
			<script>
				sessionStorage.setItem("sessionNickName", '${sessionNickName}');
				sessionStorage.setItem("sessionID", '${sessionID}');
			</script>
		</c:if>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

