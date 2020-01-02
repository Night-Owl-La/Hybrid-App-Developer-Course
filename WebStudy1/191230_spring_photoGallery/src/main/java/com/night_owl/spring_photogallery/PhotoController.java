package com.night_owl.spring_photogallery;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import service.PhotoService;
import vo.MemberVo;
import vo.PhotoVo;

@Controller
public class PhotoController {

	@Autowired
	PhotoService ps;

	@Autowired
	ServletContext application;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	@RequestMapping("/photo/list.do")
	public String photoList(Model model) {
		List<PhotoVo> list = ps.selectList();
		model.addAttribute("list", list);

		return "photo/photo_list";
	}

	@RequestMapping(value="/photo/photo_one.do", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String photoGetOne(Model model) {

		int p_idx = Integer.parseInt(request.getParameter("p_idx"));

		PhotoVo vo = ps.selectOne(p_idx);
		
		String p_content = vo.getP_content().replaceAll("\"",  "\'");

		StringBuffer jsonStr_t = new StringBuffer();
		jsonStr_t.append("{");
		jsonStr_t.append(String.format("\"p_filename\": \"%s\",", vo.getP_filename()));
		jsonStr_t.append(String.format("\"p_subject\": \"%s\",", vo.getP_subject()));
		jsonStr_t.append(String.format("\"p_content\": \"%s\"", p_content));
		jsonStr_t.append("}");

		String jsonStr = jsonStr_t.toString();

		model.addAttribute("vo", vo);
		model.addAttribute("jsonStr", jsonStr);

		return jsonStr;
	}

	@RequestMapping("/photo/insert_form.do")
	public String photoInsert_Form(Model model) {
		return "photo/photo_insert_form";
	}

	@RequestMapping("/photo/insert.do")
	public String photoInsert(PhotoVo vo, MultipartFile photo, Model model) throws IllegalStateException, IOException {
		
		// 경로 얻기.
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		String filename = "no_file";

		// 파일 Empty 체크.
		if (photo.isEmpty() == false) {
			filename = photo.getOriginalFilename();

			File f = new File(abs_path, filename);

			if (f.exists()) {
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				f = new File(abs_path, filename);
			}
			photo.transferTo(f);

			vo.setP_filename(filename);
		}
		
		// session에서 유저 정보 얻기. [로그인이 되어 있을 때]
		MemberVo m_vo = (MemberVo) session.getAttribute("user");
		
		// 유저 idx 패스.
		vo.setM_idx(m_vo.getIdx());
		
		// ip 얻기.
		vo.setP_ip(request.getRemoteAddr());
		
		// DB 삽입.
		ps.insert(vo);

		model.addAttribute("vo", vo);

		return "redirect:list.do";
	}
	
	@RequestMapping("/photo/delete.do")
	public String photoDelete(int p_idx) {
		
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);
		
		String filename = ps.selectOne(p_idx).getP_filename();
		
		File f = new File(abs_path, filename);
		f.delete();
		
		ps.delete(p_idx);
		return "redirect:list.do";
	}

}
