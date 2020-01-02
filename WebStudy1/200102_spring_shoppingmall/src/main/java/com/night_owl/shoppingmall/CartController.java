package com.night_owl.shoppingmall;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CartService;
import vo.CartVo;
import vo.MemberVo;

@Controller
public class CartController {

	@Autowired
	CartService cart_Service;

	@Autowired
	HttpSession session;

	@RequestMapping("shop/cart_list.do")
	public String CartList(Model model) {
		MemberVo user = (MemberVo) session.getAttribute("user");

		if (user == null) {
			model.addAttribute("reason", "fail_cart_not_login");
			return "/member/login_form.do";
		}

		model.addAttribute("list", cart_Service.selectList(user.getIdx()));
		model.addAttribute("amount", cart_Service.selectAmount_Total(user.getIdx()));

		return "shop/cart_list";
	}

	@RequestMapping(value = "shop/cart_Insert.do", produces = "html/plain; charset=utf-8")
	@ResponseBody
	public String CartInsert(CartVo vo) {
		int c_cnt = 1;
		vo.setC_cnt(1);

		cart_Service.insert(vo);

		StringBuffer jsonStr = new StringBuffer();
		jsonStr.append("{");
		jsonStr.append("\"ok\": \"ok\"");
		jsonStr.append("}");

		return jsonStr.toString();
	}

	@RequestMapping("shop/cart_update.do")
	public String CartUpdate(int c_idx, int c_cnt) {

		CartVo vo = new CartVo();

		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);

		cart_Service.update(vo);

		return "redirect:cart_list.do";
	}

	@RequestMapping("shop/cart_delete.do")
	public String CartDelete(int c_idx) {
		cart_Service.delete(c_idx);
		return "redirect:cart_list.do";
	}

}
