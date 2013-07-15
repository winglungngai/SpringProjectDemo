package org.spring.demo.controller;

import java.util.Date;
import java.util.List;

import org.spring.demo.dao.WorkLogDAO;
import org.spring.demo.model.Tea;
import org.spring.demo.model.WorkLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@RequestMapping("/about")
public class AboutController {
 
	@RequestMapping(value="", method = RequestMethod.GET)
	public String about(ModelMap model) {
		//Spring uses InternalResourceViewResolver and return back index.jsp
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		WorkLogDAO worklogDAO = (WorkLogDAO) context.getBean("worklogDAO");

		List<WorkLog> worklogs = worklogDAO.findAllWorkLogs();
		model.addAttribute("worklogs", worklogs);
		
		return "about";
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public String about(ModelMap model, @RequestParam(value = "content", required=false) String content) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		WorkLogDAO worklogDAO = (WorkLogDAO) context.getBean("worklogDAO");
		WorkLog worklog = new WorkLog("Wing", content, new Date());
		worklogDAO.insert(worklog);
		
		List<WorkLog> worklogs = worklogDAO.findAllWorkLogs();
		model.addAttribute("worklogs", worklogs);
		
		return "about";
	}
}
