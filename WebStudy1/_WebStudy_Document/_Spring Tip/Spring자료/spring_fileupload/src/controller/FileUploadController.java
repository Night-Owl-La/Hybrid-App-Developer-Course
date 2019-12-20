package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

public class FileUploadController {

	String uploadDirectory;
	
	
	public FileUploadController(String uploadDirectory) {
		super();
		this.uploadDirectory = uploadDirectory;
		System.out.println("----FileUploadController----");
	}


	@RequestMapping(value="/upload.do")
	public ModelAndView upload(@RequestParam MultipartFile upfile) throws Exception
	{
		System.out.println("----fileup----");
		Map map = new HashMap();
		boolean b = upfile.isEmpty();
		if(!b){
			System.out.println("---- 업로드된 파일 정보 ------");
			String fileName = upfile.getOriginalFilename();
			long filesize = upfile.getSize();
			System.out.println("파일명 : " + fileName +", 크기 : " + filesize );
			upfile.transferTo(new File(uploadDirectory,fileName));
			map.put("fileName", fileName);
		}
		
		return new ModelAndView("/upload_res.jsp",map);
	}
}
