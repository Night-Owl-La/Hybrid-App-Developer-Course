package com.night_owl.spring_aop;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.TestService;

@Controller
public class TestController {

	TestService test_Service;

	public TestService getTest_Service() {
		return test_Service;
	}

	public void setTest_Service(TestService test_Service) {
		this.test_Service = test_Service;
	}

	@RequestMapping("/list.do")
	public String list(Model model) {
		Map map = test_Service.list();

		model.addAttribute("map", map);
		return "test_list";
	}
}