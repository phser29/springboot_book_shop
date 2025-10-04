package org.zerock.book_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.book_shop.dto.MemberVO;
import org.zerock.book_shop.service.MemberService;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/login")
	public void login() {
		log.info("로그인 진입");
	}
	
	@GetMapping("/member/join")
	public void join() {
		log.info("회원가입 진입");
	}
	
	@PostMapping("/member/memberJoin")
	public String postMethodName(MemberVO member) throws Exception {
		
		log.info("join 통과");
		
		memberService.memberJoin(member);
		
		log.info("join service 통과");
		
		return "redirect:/index";
	}
	
	@PostMapping("/member/memberIdChk")
	@ResponseBody
	public String postMethodName(String memberId) throws Exception {
		
		log.info("memberIdChk : " + memberId);
		
		int result = memberService.memberIdChk(memberId);
		log.info("result : " + result);
		
		if(result != 0) {
			return "fail";
		} else {
			return "success";
		}
	}
	
	// @postMapping("/member/memberLogin")
	// @ResponseBody
	// public String postMemberLogin(MemberVO member) throws Exception {
		
	// 	log.info("memberLogin : " + member);
		
	// 	MemberVO login = memberService.memberLogin(member);
		
	// 	log.info("login : " + login);
		
	// 	if(login != null) {
	// 		return "success";
	// 	} else {
	// 		return "fail";
	// 	}
	// }
	
}
