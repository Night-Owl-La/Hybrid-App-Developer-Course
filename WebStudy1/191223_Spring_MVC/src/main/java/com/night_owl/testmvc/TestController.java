package com.night_owl.testmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/test.do")
	public String test(Model model) {
		String msg = "test-안녕";
		
		model.addAttribute("msg", msg);
		
		return "test/test_hello";
	}
	
	@RequestMapping("/test2.do")
	public ModelAndView test2() {
		String msg = "test2-hi";
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", msg);
		
		mv.setViewName("test/test_hello");
		
		return mv;
	}

}
