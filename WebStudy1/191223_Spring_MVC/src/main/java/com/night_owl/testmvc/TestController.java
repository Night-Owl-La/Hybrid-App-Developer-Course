package com.night_owl.testmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	public TestController() {
		System.out.println("---test controller ---");
	}
	
	@RequestMapping("/hello.do")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/hi.do")
	public String hi() {
		return "hi/hi";
	}

}
