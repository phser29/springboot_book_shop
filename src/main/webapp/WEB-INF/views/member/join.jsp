<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="../resources/css/join.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 도로명 주소 map -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원가입</h4>
				<form id="join-form">
					<div class="mb-3">
						<label for="id_input">ID</label> <input type="text"
							class="form-control" id="id_input" placeholder="ID" required>
						<div class="id_feedback">ID을 입력해주세요.</div>
						<span class="id_input_re_1">사용 가능한 아이디입니다.</span> 
						<span class="id_input_re_2">아이디가 이미 존재합니다.</span>
					</div>

					<div class="mb-3">
						<label for="pw_input">비밀번호</label> 
						<input type="password" class="form-control" id="pw_input" placeholder="PW" required>
						<div class="pw_feedback">비밀번호를 입력해주세요.</div>
					</div>

					<div class="mb-3">
						<label for="pw_input_check">비밀번호 확인</label> 
						<input type="password" class="form-control" id="pw_input_check" placeholder="PWCheck" required>
						<div class="pwck_feedback2">비밀번호가 일치하지 않습니다.</div>
						<div class="pwck_feedback1">비밀번호가 일치합니다.</div>
					</div>

					<div class="mb-3">
						<label for="name_input">이름</label> 
						<input type="text" class="form-control" id="name_input" placeholder="name" required>
						<div class="name_feedback">이름을 입력해주세요.</div>
					</div>

					<div class="mb-3">
						<label for="email_input">이메일</label>
						<button class="inputButton" id="emailsend" type="button">인증번호
							전송</button>
						<div class="mail_input_box">
							<input type="text" class="form-control" id="email_input" placeholder="you@example.com" required>
						</div>
						<div class="mail_check_input_box" id="mail_check_input_box_false">
							<input type="text" class="form-control" id="emailcft"
								placeholder="인증번호" required>
						</div>
						<div class="email_feedback">이메일을 입력해주세요.</div>
						<span id="mail_check_input_box_warn"></span>
					</div>

					<div class="mb-3">
						<label for="memberAddr">주소</label>
						<button onclick="daum_address()" type="button" class="inputButton">주소찾기</button>
						<input type="text" class="form-control" id="addr1_input" placeholder="우편번호" readonly="readonly"> 
						<input type="text" class="form-control" id="addr2_input" placeholder="서울특별시 강남구" readonly="readonly"> 
						<input type="text" class="form-control" id="addr3_input" placeholder="상세주소를 입력해주세요.">
						<div class="addr_feedback">주소를 입력해주세요.</div>
					</div>

					<hr class="mb-4">
					<div class="custom-control custom-checkbox">
						<input type="checkbox" onclick="check()"
							class="custom-control-input" id="aggrement" required> <label
							class="custom-control-label" for="aggrement">개인정보 수집 및
							이용에 동의합니다.</label>
					</div>
					<div class="mb-4"></div>
					<button class="join_button btn btn-primary btn-lg btn-block"
						type="button">가입 완료</button>
					<button class="join-back btn btn-secondary btn-lg btn-block"
						type="button">뒤로 가기</button>
				</form>
			</div>
		</div>
	</div>
	<script src="../resources/js/join.js"></script>
</body>

</html>