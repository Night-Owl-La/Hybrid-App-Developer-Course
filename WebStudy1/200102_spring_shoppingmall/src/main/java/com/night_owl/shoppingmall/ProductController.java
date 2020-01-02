
package com.night_owl.shoppingmall;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDao;
import service.ProductService;
import vo.ProductVo;

@Controller
public class ProductController {

	@Autowired
	ProductService product_Service;

	@Autowired
	ServletContext application;

	@Autowired
	HttpServletRequest request;

	@RequestMapping("/shop/product_list.do")
	public String ProductList(Model model) {

		String category = request.getParameter("category");

		// check category is blank or null.
		if (category == "" || category == null)
			category = "com001";

		model.addAttribute("list", product_Service.selectList(category));

		return "shop/product_list";
	}
	
	@RequestMapping("/shop/product_view.do")
	public String ProductView(int idx, Model model) {
		ProductVo vo = product_Service.selectOne(idx);
		model.addAttribute("vo", vo);

		return "shop/product_content";
	}
	
	

	@RequestMapping("/shop/product_insert_form.do")
	public String productInsert_Form() {
		return "shop/product_reg_form";

	}

	@RequestMapping("/shop/product_insert.do")
	public String productInsert(ProductVo vo, @RequestParam("files") MultipartFile[] files, Model model)
			throws IllegalStateException, IOException {

		// 파일 업로드 처리
		product_File_Upload(vo, files);

		product_Service.insert(vo);

		model.addAttribute("vo", vo);
		model.addAttribute("category", vo.getCategory());

		return "redirect:product_list.do";
	}

	@RequestMapping("/shop/product_modify_form.do")
	public String productModify_Form(int idx, Model model) {
		ProductVo vo = product_Service.selectOne(idx);
		model.addAttribute("vo", vo);

		return "shop/product_modify";

	}

	@RequestMapping("/shop/product_modify.do")
	public String productModify(ProductVo vo, @RequestParam("files") MultipartFile[] files, Model model)
			throws IllegalStateException, IOException {
		
		product_Old_File_Remove(vo.getIdx());
		product_File_Upload(vo, files);

		product_Service.update(vo);

		return "redirect:product_list.do";

	}

	@RequestMapping("/shop/product_delete.do")
	public String productDelete(int idx, Model model) {
		
		product_Old_File_Remove(idx);
		product_Service.delete(idx);

		return "redirect:product_list.do";

	}
	
	public void product_Old_File_Remove(int idx) {
		
		String web_path = "/resources/images";
		String abs_path = application.getRealPath(web_path);
		
		// get old file name.
		String old_p_image_s = product_Service.selectOne(idx).getP_image_s();
		String old_p_image_l = product_Service.selectOne(idx).getP_image_l();

		// old file delete.
		File old_file_s = new File(abs_path, old_p_image_s);
		File old_file_l = new File(abs_path, old_p_image_l);

		old_file_s.delete();
		old_file_l.delete();
		
	}

	public void product_File_Upload(ProductVo vo, MultipartFile[] files) throws IllegalStateException, IOException {

		String web_path = "/resources/images";
		String abs_path = application.getRealPath(web_path);

		String filename1 = "no_file";
		String filename2 = "no_file";

		String filename = "";
		MultipartFile[] file_Array = files;

		for (int i = 0; i < file_Array.length; i++) {

			MultipartFile file = file_Array[i];

			if (file.isEmpty() == false) {
				filename = file.getOriginalFilename();

				File f = new File(abs_path, filename);

				if (f.exists()) {
					long time = System.currentTimeMillis();
					filename = String.format("%d_%s", time, filename);
					f = new File(abs_path, filename);
				}
				file.transferTo(f);
			}
			if (i == 0) {
				filename1 = filename;
				vo.setP_image_s(filename1);
			}

			else if (i == 1) {
				filename2 = filename;
				vo.setP_image_l(filename2);
			}
		}

	}

}
