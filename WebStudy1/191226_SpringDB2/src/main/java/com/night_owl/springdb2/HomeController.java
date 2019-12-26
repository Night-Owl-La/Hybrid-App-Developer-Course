package com.night_owl.springdb2;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.Gogek_Service;
import vo.GogekVo;

@Controller
public class HomeController {

	Gogek_Service gs;

	public Gogek_Service getGs() {
		return gs;
	}

	public void setGs(Gogek_Service gs) {
		this.gs = gs;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<GogekVo> list = gs.selectList();
		return "home";
	}

	@RequestMapping("/gogek/list.do")
	public String list(Model model) {
		List<GogekVo> list = gs.selectList();
		model.addAttribute("list", list);

		return "gogek/gogek_list";
	}

}
