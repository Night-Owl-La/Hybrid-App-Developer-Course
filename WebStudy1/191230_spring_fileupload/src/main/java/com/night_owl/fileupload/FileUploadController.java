package com.night_owl.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVo;
import vo.PhotoVo2;

@Controller
public class FileUploadController {

	@Autowired
	ServletContext application;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@RequestMapping("/insert_form.do")
	public String insert_form() {
		return "insert_form";
	}

	// 복수 파일 처리.
	@RequestMapping("/insert_form2.do")
	public String insert_form2() {
		return "insert_form2";
	}

	@RequestMapping("/file_upload1.do")
	public String file_upload1(String title, MultipartFile photo, Model model)
			throws IllegalStateException, IOException {
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		String filename = "no_file";

		if (photo.isEmpty() == false) {
			filename = photo.getOriginalFilename();

			File f = new File(abs_path, filename);

			if (f.exists()) {
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				f = new File(abs_path, filename);
			}
			photo.transferTo(f);
		}

		model.addAttribute("title", title);
		model.addAttribute("filename", filename);

		return "result_upload1";
	}

	@RequestMapping("/file_upload2.do")
	public String file_upload2(PhotoVo vo, Model model) throws IllegalStateException, IOException {
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";

		if (photo.isEmpty() == false) {
			filename = photo.getOriginalFilename();

			File f = new File(abs_path, filename);

			if (f.exists()) {
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				f = new File(abs_path, filename);
			}
			photo.transferTo(f);

			vo.setFilename(filename);
		}

		model.addAttribute("vo", vo);

		return "result_upload2";
	}

	@RequestMapping("/multi_file_upload.do")
	public String multi_file_upload(String title, @RequestParam("photo") MultipartFile[] photo_Array, Model model)
			throws IllegalStateException, IOException {
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		String filename1 = "no_file";
		String filename2 = "no_file";

		String filename = "";

		for (int i = 0; i < photo_Array.length; i++) {

			MultipartFile photo = photo_Array[i];

			if (photo.isEmpty() == false) {
				filename = photo.getOriginalFilename();

				File f = new File(abs_path, filename);

				if (f.exists()) {
					long time = System.currentTimeMillis();
					filename = String.format("%d_%s", time, filename);
					f = new File(abs_path, filename);
				}
				photo.transferTo(f);
			}
			if (i == 0)
				filename1 = filename;
			else if (i == 1)
				filename2 = filename;

		}

		model.addAttribute("title", title);
		model.addAttribute("filename1", filename1);
		model.addAttribute("filename2", filename2);

		return "result_multi_upload";
	}

	@RequestMapping("/multi_file_upload2.do")
	public String multi_file_upload2(PhotoVo2 vo, Model model) throws IllegalStateException, IOException {
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		String filename1 = "no_file";
		String filename2 = "no_file";

		String filename = "";
		MultipartFile[] photo_Array = vo.getPhoto();

		for (int i = 0; i < photo_Array.length; i++) {

			MultipartFile photo = photo_Array[i];

			if (photo.isEmpty() == false) {
				filename = photo.getOriginalFilename();

				File f = new File(abs_path, filename);

				if (f.exists()) {
					long time = System.currentTimeMillis();
					filename = String.format("%d_%s", time, filename);
					f = new File(abs_path, filename);
				}
				photo.transferTo(f);
			}
			if (i == 0) {
				filename1 = filename;
				vo.setFilename1(filename1);
			}

			else if (i == 1) {
				filename2 = filename;
				vo.setFilename2(filename2);
			}
		}

		model.addAttribute("vo", vo);

		return "result_multi_upload2";
	}

}