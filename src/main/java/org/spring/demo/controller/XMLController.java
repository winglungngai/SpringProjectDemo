package org.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.spring.demo.model.Coffee;
import org.spring.demo.model.Tea;
 
@Controller
public class XMLController {
 
	@RequestMapping(value="/coffee/{name}/{weight}", method = RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeInXML(@PathVariable("name") String name, @PathVariable("weight") Integer weight) {
		
		Coffee coffee = new Coffee(name, weight*2);
		return coffee;
	}
	
	@RequestMapping(value="/tea", method = RequestMethod.GET)
	public @ResponseBody Tea getTeaInXML(
			@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "weight", required=false) int weight,
			@RequestParam(value = "origin", required=false) String origin) {
		
		Tea tea = new Tea(name, weight*2, origin);
		return tea;
	}
 
}