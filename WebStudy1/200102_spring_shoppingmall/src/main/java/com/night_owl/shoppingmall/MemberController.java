package com.night_owl.shoppingmall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MemberService;
import vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	MemberService member_Service;
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;
	

	@RequestMapping("/member/list.do")
	public String memberList(Model model) {
		List<MemberVo> list = member_Service.selectList();
		model.addAttribute("list", list);

		return "member/member_list";
	}

	@RequestMapping("/member/login_form.do")
	public String memberLogin_Form() {
		return "member/member_login_form";
	}

	@RequestMapping("/member/login.do")
	public String memberLogin(Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberVo user = member_Service.selectOne(id);
		if (user == null) {
			model.addAttribute("reason", "fail_id");
			return "redirect:login_form.do";
		}

		if (user.getPwd().equals(pwd) == false) {
			model.addAttribute("reason", "fail_pwd");
			return "redirect:login_form.do";
		}

		// 세션 생성.
		session.setAttribute("user", user);

		return "redirect:list.do";
	}

	@RequestMapping("member/logout.do")
	public String memberLogout() {
		session.removeAttribute("user");

		return "redirect:member/list.do";
	}

	@RequestMapping("/member/check_id.do")
	@ResponseBody
	public String memberCheck_Id(Model model) {

		String id = request.getParameter("id");

		MemberVo vo = member_Service.selectOne(id);

		boolean result = false;

		if (vo == null)
			result = true;

		String jsonStr = String.format("{\"result\":%b}", result);

		model.addAttribute("jsonStr", jsonStr);

		return jsonStr;
	}

	@RequestMapping("/member/insert_form.do")
	public String memberInsert_Form() {
		return "member/member_insert_form";
	}

	@RequestMapping("/member/insert.do")
	public String memberInsert(MemberVo vo, Model model) {
		vo.setIp(request.getRemoteAddr());
		member_Service.insert(vo);

		model.addAttribute("vo", vo);
		return "redirect:list.do";
	}

	@RequestMapping("/member/modify_form.do")
	public String memberModify_Form(Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		MemberVo vo = member_Service.selectOne(idx);
		vo.setIp(request.getRemoteAddr());

		model.addAttribute("vo", vo);
		return "member/member_modify_form";
	}

	@RequestMapping("/member/modify.do")
	public String memberModify(MemberVo vo, Model model) {
		member_Service.update(vo);

		model.addAttribute("vo", vo);
		return "redirect:list.do";
	}

	@RequestMapping("/member/delete.do")
	public String memberDelete() {
		int idx = Integer.parseInt(request.getParameter("idx"));
		member_Service.delete(idx);

		return "redirect:list.do";

	}
}
