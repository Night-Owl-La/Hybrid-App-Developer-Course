package com.night_owl.spring_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SawonService;

@Controller
public class SawonController {
	
	@Autowired
	SawonService sm;
	
	@RequestMapping("/sawon/list.do")
	public String sawonList(Model model) {
		
		model.addAttribute("list", sm.selectList());
		return "sawon/sawon_list";
	}

}
