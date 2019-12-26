package com.night_owl.springdb3;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.Sungtb_Service;
import vo.SungtbVo;

@Controller
public class HomeController {

	Sungtb_Service ss = null;

	public Sungtb_Service getSs() {
		return ss;
	}

	public void setSs(Sungtb_Service ss) {
		this.ss = ss;
	}

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/sungtb/list.do")
	public String list(Model model) {
		List<SungtbVo> list = ss.selectList();
		model.addAttribute("list", list);
		return "sungtb/sungtb_list";
	}

}
