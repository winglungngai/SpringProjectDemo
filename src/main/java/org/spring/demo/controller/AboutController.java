package org.spring.demo.controller;

import java.util.List;
import org.spring.demo.dao.WorkLogDAO;
import org.spring.demo.model.WorkLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
 
@Controller
@RequestMapping("/about")
public class AboutController {
 
	@RequestMapping(value="")
	public String about(ModelMap model) {
		//Spring uses InternalResourceViewResolver and return back index.jsp
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		WorkLogDAO worklogDAO = (WorkLogDAO) context.getBean("worklogDAO");
		//WorkLog worklog1 = worklogDAO.findByWorkLogId(1);
		
		List<WorkLog> worklogs = worklogDAO.findAllWorkLogs();
		model.addAttribute("worklogs", worklogs);
		
		return "about";
	}
}
