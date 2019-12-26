package com.night_owl.SpringDB;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.DeptService;
import vo.DeptVo;

@Controller
public class DeptController {

	DeptService ds;

	public DeptService getDs() {
		return ds;
	}

	public void setDs(DeptService ds) {
		System.out.println("################# dept_controller #################");
		this.ds = ds;
	}

	@RequestMapping("/dept/list.do")
	public String list(Model model) {
		
		List<DeptVo> list = ds.selectList();
		model.addAttribute("list", list);
		
		return "dept/dept_list";
	}

}
