package org.zerock.book_shop.service;

import java.util.Random;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
	
	private final JavaMailSender javaMailSender;
	
	public String createNumber() {
		Random random = new Random();
		StringBuilder key = new StringBuilder();
		
		for(int i=0; i<8; i++) {
			int index = random.nextInt(3);
			
			switch (index) {
				case 0 -> key.append((char) (random.nextInt(26) + 97));
				case 1 -> key.append((char) (random.nextInt(26) + 57));
				case 2 -> key.append(random.nextInt(10));
			}
		}
		
		return key.toString();
	}
	
	public MimeMessage createMail(String mail, String number) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		message.setFrom(mail);
		message.setRecipients(MimeMessage.RecipientType.TO, mail);
		message.setSubject("이메일 인증");
		String body = "";
		body += "<h3>요청하신 인증 번호입니다.</h3>";
		body += "<h1>"+number+"</h1>";
		body += "<h3>요청하신 인증 번호입니다.</h3>";
		message.setText(body, "UTF-8", "html");
		return message;
	}
	
	public String sendSimpleMesage(String sendEmail) throws MessagingException {
		String number = createNumber();
		
		MimeMessage message = createMail(sendEmail, number);
		try {
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("메일 발송 중 오류가 발생했습니다.");
		}
		
		return number;
	}
}
