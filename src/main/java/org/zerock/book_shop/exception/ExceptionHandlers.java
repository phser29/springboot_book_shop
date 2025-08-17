package org.zerock.book_shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.mail.MessagingException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> runtimeException(RuntimeException ex) {
		log.error("RuntimeException..." + ex);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException ex) {
		log.error("IllegalArgumentException..." + ex);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MessagingException.class)
	public ResponseEntity<Object> messagingException(MessagingException ex) {
		log.error("MessagingException..." + ex);
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
