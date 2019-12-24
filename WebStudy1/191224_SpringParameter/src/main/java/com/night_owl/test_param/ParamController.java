package com.night_owl.test_param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.night_owl.test_param.vo.PersonVo;

@Controller
public class ParamController {

	public ParamController() {
	}

	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return "param/insert_form";
	}

	// case 1
	@RequestMapping("/insert.do")
	public String insert(Model model, HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String tel = request.getParameter("tel");
		String[] hobby = request.getParameterValues("hobby");

		PersonVo vo = new PersonVo(name, age, tel, hobby);
		model.addAttribute("title", "직접받기");
		model.addAttribute("vo", vo);

		return "param/result_person";
	}

	// case 2
	@RequestMapping("/insert1.do")
	public String insert1(String name, int age, String tel, String[] hobby, Model model) {

		PersonVo vo = new PersonVo(name, age, tel, hobby);

		model.addAttribute("title", "낱개로 받기");
		model.addAttribute("vo", vo);

		return "param/result_person";
	}

	// case 3
	@RequestMapping("/insert2.do")
	public String insert2(PersonVo vo, Model model) {

		model.addAttribute("title", "객체로 받기");
		model.addAttribute("vo", vo);

		return "param/result_person";
	}

	@RequestMapping(value = "/qna.do", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String qna(int que) {
		String answer = "";

		switch (que) {
		case 1:
			answer = "one";
			break;
		case 2:
			answer = "two";
			break;
		case 3:
			answer = "three";
			break;

		default:
			answer = "???";
			break;
		}

		String result = String.format("readed no=[%d] is [%s] by en. ㅇ", que, answer);

		return result;
	}

	@RequestMapping("/list.do")
	public String list(Model model) {
		int idx2 = 1234;
		model.addAttribute("idx2", idx2);
		return "param/list";
	}
	

	@RequestMapping("/delete.do")
	public String delete(int idx, Model model) {
		
		model.addAttribute("idx", idx);
		return "redirect:list.do";
	}

}