package org.zerock.book_shop.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Log4j2
public class HomeController {
	
	@GetMapping("/index")
	public void index() {
		log.info("홈으로 진입");
	}
	
	
}
