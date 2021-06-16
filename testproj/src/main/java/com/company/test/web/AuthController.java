package com.company.test.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.test.service.OneMemoService;


@Controller
public class AuthController {
	
	
	@Resource(name="memoService")
	private OneMemoService memoService;
	
	//로그인 처리]
	@RequestMapping("LoginProcess.do")
	public String process(@RequestParam Map map,Model model,HttpSession session) {
		boolean flag=memoService.isLogin(map);
		if(flag) {
			session.setAttribute("id", map.get("id"));
			return "list";
		}
		else {
			model.addAttribute("NotMember", "아뒤와 비번이 틀려요");
			return "login";
		}
	}
	@RequestMapping("Logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
}
