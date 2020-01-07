package com.night_owl.spring_transaction;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.product_service.ProductService;
import vo.product_vo.ProductVo;

@Controller
public class ProductController {

	ProductService product_Service;

	public void setProduct_Service(ProductService product_Service) {
		this.product_Service = product_Service;
	}

	@RequestMapping("/product/list.do")
	public String list(Model model) {

		Map map = product_Service.selectList();
		model.addAttribute("map", map);
		return "product/product_list";
	}

	@RequestMapping("/product/insert_in.do")
	public String insert_in(ProductVo vo) {

		try {
			int res = product_Service.insert_in(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list.do";
	}

	@RequestMapping("/product/insert_out.do")
	public String insert_out(ProductVo vo, Model model) {

		try {
			int res = product_Service.insert_out(vo);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "redirect:list.do";
	}

	@RequestMapping("/product/delete_in.do")
	public String delete_in(int idx, Model model) {

		try {
			int res = product_Service.delete_in(idx);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "redirect:list.do";
	}

	@RequestMapping("/product/delete_out.do")
	public String delete_out(int idx, Model model) {

		try {
			int res = product_Service.delete_out(idx);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "redirect:list.do";
	}

}
