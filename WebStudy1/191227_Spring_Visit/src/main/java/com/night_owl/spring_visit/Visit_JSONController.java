package com.night_owl.spring_visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.VisitService;
import vo.VisitVo;

@Controller
public class Visit_JSONController {
	
	@Autowired
	VisitService vs = null;
	

	@RequestMapping("/visit/json/list.do")
	@ResponseBody
	public Map list(String search, String search_text) {
		if (search == null)	search = "all";
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
		
		Map<String, List<VisitVo>> result_Map = new HashMap<String, List<VisitVo>>();
		result_Map.put("list", list);

		return result_Map;
	}

	@RequestMapping("/visit/json/check_pwd.do")
	@ResponseBody
	public Map check(int idx, String c_pwd, Model model) {
		VisitVo vo = vs.selectOne(idx);

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", vo.getPwd().equals(c_pwd));

		return map;
	}

	@RequestMapping("/visit/json/insert.do")
	@ResponseBody
	public Map insert(Model model, HttpServletRequest request, VisitVo vo) {
		vo.setIp(request.getRemoteAddr());
		int res = vs.insert(vo);
		
		Map map = new HashMap();
		map.put("result", res);

		return map;
	}

	@RequestMapping("/visit/json/modify.do")
	@ResponseBody
	public Map modify(HttpServletRequest request, VisitVo vo) {
		vo.setIp(request.getRemoteAddr());
		int res = vs.update(vo);
		Map map = new HashMap();
		map.put("result", res);
		return map;
	}

	@RequestMapping("visit/json/delete.do")
	@ResponseBody
	public Map delete(int idx) {
		int res = vs.delete(idx);
		Map map = new HashMap();
		map.put("result", res);
		return map;
	}


}
