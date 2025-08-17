package org.zerock.book_shop.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.book_shop.service.MailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class MailController {
	
	private final MailService mailService;
	private String authCode;
	
	@GetMapping("/emailCheck")
	public String emailCheck(String email) throws MessagingException, UnsupportedEncodingException {
		authCode = mailService.sendSimpleMesage(email);
		
		log.info(authCode);
		
		return authCode;
	}
	
	
}
