package com.night_owl.spring_board;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CKEditor_ImageUploadController {

	@Autowired
	ServletContext application;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/ckeditorImageUpload.do", produces = "text/html; charset=utf-8;")
	@ResponseBody
	public String upload(@RequestParam("upload") MultipartFile upload) throws Exception {
		String web_path = "/resources/upload/";
		String abs_path = application.getRealPath(web_path);

		String fileName = "";
		if (upload.isEmpty() == false) {
			fileName = upload.getOriginalFilename();

			File f = new File(abs_path, fileName);
			// 동일화일이 있는경우
			if (f.exists()) {
				long t = System.currentTimeMillis();
				fileName = String.format("%d_%s", t, fileName);

				f = new File(abs_path, fileName);
			}
			upload.transferTo(f);
		}

		// 결과데이터 생성
		String url = request.getRequestURL().toString().replaceAll("/ckeditorImageUpload.do", "");
		// System.out.println(url);

		String fileUrl = url + web_path + fileName;// url경로
		String sendData = String.format("{\"filename\" : \"%s\", \"uploaded\" : 1, \"url\":\"%s\"}", fileName, fileUrl);

		return sendData;
	}

}
