package com.company.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class IndexController {
	
	
	//컨트롤러 메소드]
	@RequestMapping("/list.do")
	public String bbs() {
		return "list";
	}
	@RequestMapping("/Login.do")
	public String login() {
		return "login";
	}


}
