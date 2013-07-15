package org.spring.demo.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("/")
public class BaseController {
 
	@RequestMapping(value="/")
	public String welcome(ModelMap model) {
		//Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";
	}
}
