package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String msg = request.getParameter("msg");
		//결과값과 이동할 뷰 이름을 ModelAndView 객체에 담기
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/jsp/test.jsp");//뷰이름
		mv.addObject("msg",msg);
		return mv;
	}

}
