package com.night_owl.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
		
	@RequestMapping("/test/test.do")
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@RequestMapping(value="/admin/list.do", produces="text/html;charset=utf-8;")
	@ResponseBody
	public String adminList() {
		return "관리자 페이지";
	}
	
	@RequestMapping(value="/adult/list.do", produces="text/html;charset=utf-8;")
	@ResponseBody
	public String adultList() {
		return "관리자 페이지";
	}
}
