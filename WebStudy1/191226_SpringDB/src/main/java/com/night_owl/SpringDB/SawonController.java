package com.night_owl.SpringDB;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SawonService;
import vo.SawonVo;

@Controller
public class SawonController {

	SawonService ds;

	public SawonService getDs() {
		return ds;
	}

	public void setDs(SawonService ds) {
		System.out.println("################# sawon_controller #################");
		this.ds = ds;
	}

	@RequestMapping("/sawon/list.do")
	public String list(Model model) {
		
		List<SawonVo> list = ds.selectList();
		model.addAttribute("list", list);
		
		System.out.println("@@@@@@@@@@@@@@@@");
		
		return "sawon/sawon_list";
	}

}
