package com.night_owl.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vo.PersonVo;

@Controller
public class JSONConvertController {

	@RequestMapping("/test_map.do")
	@ResponseBody
	public Map test_map() {

		Map map = new HashMap();
		map.put("user_id", "hong");
		map.put("user_name", "길동");
		map.put("user_age", 20);

		return map;
	}

	@RequestMapping("/test_person.do")
	@ResponseBody
	public PersonVo test_person() {
		return new PersonVo("일길동", 30, "010-111-1234");
	}
	
	@RequestMapping("/test_arraylist.do")
	@ResponseBody
	public List test_arraylist() {
		List<PersonVo> list = new ArrayList<PersonVo>();
		list.add(new PersonVo("일길동", 20, "010-111-1234"));
		list.add(new PersonVo("이길동", 30, "010-112-1234"));
		list.add(new PersonVo("삼길동", 40, "010-113-1234"));
		return list;
	}
	
	@RequestMapping("/test_arraylist2.do")
	@ResponseBody
	public Map test_arraylist2() {
		List<PersonVo> list = new ArrayList<PersonVo>();
		list.add(new PersonVo("일길동", 20, "010-111-1234"));
		list.add(new PersonVo("이길동", 30, "010-112-1234"));
		list.add(new PersonVo("삼길동", 40, "010-113-1234"));
		
		Map map = new HashMap();
		map.put("p_list", list);
		return map;
	}
	
	@RequestMapping("/test_userinfo.do")
	@ResponseBody
	public Map test_userinfo() {
		Map result_Map = new HashMap();
		
		Map<String, String> name = new HashMap<String, String>();
		name.put("last_name", "홍");
		name.put("first_name", "길동");
		
		Map<String, String> tel = new HashMap<String, String>();
		tel.put("home", "02-111-2345");
		tel.put("phone", "010-111-2222");
		
		List<String> hobby = new ArrayList<String>();
		hobby.add("낚시");
		hobby.add("영화");
		hobby.add("독서");
		
		
		result_Map.put("name", name);
		result_Map.put("age", 20);
		result_Map.put("tel", tel);
		result_Map.put("hobby", hobby);
		
		return result_Map;
	}

}
