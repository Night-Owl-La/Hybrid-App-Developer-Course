package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.PersonVo;

@Controller
public class InsertAnnotationController {

	@RequestMapping("/test.do")
	
	public ModelAndView test(@ModelAttribute("vo")PersonVo vo,BindingResult result){
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/jsp/test.jsp");
		mv.addObject("vo", vo);
		
		return mv;
		
	}
}
