package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import vo.PersonVo;

public class InsertController extends AbstractCommandController {


	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object obj, BindException e)
			throws Exception {
		// TODO Auto-generated method stub
		PersonVo vo =(PersonVo)obj;
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/jsp/test.jsp");
		mv.addObject("vo",vo);
		
		return mv;
	}

}
