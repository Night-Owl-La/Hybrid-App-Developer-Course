package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import target.Service;

@Controller
public class TargetController {

	
	Service service;
	
	@RequestMapping("/target.do")
	public ModelAndView exe() throws Exception {
		
		service.sayHello();
		
		return null;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
}
