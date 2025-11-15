let idCheck = false;
let idckCheck = false;
let pwCheck = false;
let pwchCheck = false;
let nameCheck = false;
let emailCheck = false;
let emailckCheck = false;
let addrCheck = false;

let code = "";

$(document).ready(function() {

	$('.join-back').on("click", function() {
		$(location).attr("href", "/index");
	});

	$('.join_button').click(function() {

		let id = $('#id_input').val();
		let pw = $('#pw_input').val();
		let name = $('#name_input').val();
		let email = $('#email_input').val();
		let addr1 = $('#addr1_input').val();
		let addr2 = $('#addr2_input').val();
		let addr3 = $('#addr3_input').val();
		let checkbox = $('#aggerment');

		if (id === "") {
			$('.id_feedback').css('display', 'block');
			idCheck = false;
		} else {
			$('.id_feedback').css('display', 'none');
			idCheck = true;
		}

		if (pw === "") {
			$('.pw_feedback').css('display', 'block');
			pwCheck = false;
		} else {
			$('.pw_feedback').css('display', 'none');
			pwCheck = true
		}

		if (pwchCheck === "") {
			$('.pwck_feedback').css('display', 'block');
			pwchCheck = false;
		} else {
			$('.pwck_feedback').css('display', 'none');
			pwchCheck = true;
		}

		if (name === "") {
			$('.name_feedback').css('display', 'block');
			nameCheck = false;
		} else {
			$('.name_feedback').css('display', 'none');
			nameCheck = true;
		}
		
		if(email === "") {
			$('.email_feedback').css('display', 'block');
			emailCheck = false;
		} else {
			$('.email_feedback').css('display', 'none');
			emailCheck = true;
		}
		
		if(addr3 === "") {
			$('.addr_feedback').css('display', 'block');
			addrCheck = false;
		} else {
			$('.addr_feedback').css('display', 'none');
			addrCheck = true;
		}

		if(idckCheck === false) {
			alert("아이디 중복체크를 해주세요.");
			return;
		}
		
		if(idCheck !== false && pwCheck !== false && pwchCheck !== false && nameCheck !== false && emailCheck !== false && addrCheck !== false && idckCheck !== false) {
			$('#join-form').attr("action", "/member/memberJoin");
			$('#join-form').attr("method", "post");
			$('#join-form').submit();
		}
	});
});

// 실시간 조회 별도 jquery 작성
$('#id_input').on("propertychange change keyup paste input", function() {
	const memberId = $("#id_input").val();
	const data = { memberId: memberId }
	if (memberId != '') {
		$.ajax({
			type: "post",
			url: "/member/memberIdChk",
			data: data,
			success: function(result) {
				if (result != 'fail') {
					$('.id_input_re_1').css("display", "inline-block");
					$('.id_input_re_2').css("display", "none");
					idckCheck = true;
				} else if (result != 'success') {
					$('.id_input_re_2').css("display", "inline-block");
					$('.id_input_re_1').css("display", "none");
					idckCheck = false;
				}
			}
		});
	} else {
		$('.id_input_re_1').css("display", "none");
		$('.id_input_re_2').css("display", "none");
	}
});

$('#pw_input_check').on('propertychange change keyup paste input', function() {
	const pw = $('#pw_input').val();
	const pwck = $('#pw_input_check').val();
	$('.pw_feedback').css('display', 'none');

	if (pwck !== '') {
		if (pw === pwck) {
			$('.pwck_feedback1').css('display', 'block');
			$('.pwck_feedback2').css('display', 'none');
		} else {
			$('.pwck_feedback1').css('display', 'none');
			$('.pwck_feedback2').css('display', 'block');
		}
	} else {
		$('.pwck_feedback1').css('display', 'none');
		$('.pwck_feedback2').css('display', 'none');
	}
});

// 이메일 인증 전송
$("#emailsend").on('click', function() {
	const email = $('.member_email').val();
	const emailcft = $('#emailcft');
	const boxWrap = $('.mail_check_input_box');

	console.log(email);

	$.ajax({
		type: "get",
		url: "/emailCheck?email=" + email,
		success: function(data) {
			emailcft.attr("disabled", false);
			boxWrap.attr('id', 'mail_check_input_box_true');
			code = data;
			console.log(code);
		}
	});
});

// 인증번호 비교 포커스를 잃는 순간 이벤트 핸들러가 실행
$('#emailcft').blur(function() {
	let inputCode = $('#emailcft').val();
	let checkResult = $('#mail_check_input_box_warn');
	if (inputCode !== '') {
		if (inputCode === code) {
			checkResult.html("인증번호가 일치합니다.");
			checkResult.attr("class", "correct");
		} else {
			checkResult.html("인증번호를 다시 확인해주세요.");
			checkResult.attr("class", "incorrect");
		}
	} else {
		checkResult.css("display", "none");
	}
});

// 다음 도로명 주소 API
function daum_address() {
	new daum.Postcode({
		oncomplete: function(data) {
			let addr = ''; // 주소 변수
			let extraAddr = ''; // 참고항목 변수

			if (data.userSelectedType === 'R') {
				addr = data.roadAddress;
			} else {
				addr = data.jibunAddress;
			}

			if (data.userSelectedType === 'R') {
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				addr += extraAddr;

			} else {
				addr += ' ';
			}

			$("#addr1_input").val(data.zonecode);
			$("#addr2_input").val(addr);
			$("#addr3_input").attr("readonly", false);
			$("#addr3_input").focus(); //커서 이동
		}
	}).open();
}





