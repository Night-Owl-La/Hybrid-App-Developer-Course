package com.night_owl.spring_visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.VisitService;
import vo.VisitVo;

@Controller
public class VisitController {

	VisitService vs = null;

	public VisitService getVs() {
		return vs;
	}

	public void setVs(VisitService vs) {
		this.vs = vs;
	}

	@RequestMapping("/visit/list.do")
	public String list(String search, String search_text, Model model) {
		if (search == null)
			search = "all";
		Map<String, String> map = new HashMap<String, String>();

		if (search.equals("all") == false) {
			// 이름+내용
			if (search.equals("name_content")) {
				map.put("name", search_text);
				map.put("content", search_text);
			} else if (search.equals("name")) {
				// 이름
				map.put("name", search_text);
			} else if (search.equals("content")) {
				// 내용
				map.put("content", search_text);
			}
		}

		List<VisitVo> list = vs.selectList(map);
		model.addAttribute("list", list);

		return "visit/list";
	}

	@RequestMapping("/visit/check_pwd.do")
	@ResponseBody
	public String check(int idx, String c_pwd, Model model) {
		VisitVo vo = vs.selectOne(idx);

		String result = "diff";
		if (vo.getPwd().equals(c_pwd)) {
			result = "same";
		}

		String resultStr = String.format("{\"result\":\"%s\"}", result);

		model.addAttribute("resultStr", resultStr);

		return resultStr;
	}

	@RequestMapping("/visit/insert_form.do")
	public String insert_form() {
		return "visit/insert_form";
	}

	@RequestMapping("/visit/insert.do")
	public String insert(Model model, HttpServletRequest request, VisitVo vo) {
		vo.setIp(request.getRemoteAddr());
		vs.insert(vo);

		return "redirect:list.do";
	}

	@RequestMapping("/visit/modify_form.do")
	public String modify_form(int idx, Model model) {

		VisitVo vo = vs.selectOne(idx);

		String content = vo.getContent().replaceAll("<br>", "\n");
		vo.setContent(content);

		model.addAttribute("vo", vo);

		return "visit/modify_form";
	}

	@RequestMapping("/visit/modify.do")
	public String modify(HttpServletRequest request, VisitVo vo) {
		vo.setIp(request.getRemoteAddr());
		vs.update(vo);
		return "redirect:list.do";
	}

	@RequestMapping("visit/delete.do")
	public String delete(int idx) {
		vs.delete(idx);
		return "redirect:list.do";
	}

}
