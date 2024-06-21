package com.sunbeam.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test") //add @RequestMapping at the class level (optional)
//to map all incoming reqs starting /test --> TestController.
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	//add rq handling method to test ModelAndView
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test mnv");
		//o.s.w.s.ModelAndView(String LVN ,String attrName,Object attrVal)
		//result - server side time stamp
		return new ModelAndView("/test/test1", 
				"server_ts", LocalDateTime.now());
	}
	//add rq handling method to test Model Map
		@GetMapping("/test2")
		public String testModelMap(Model modelMap) {
			System.out.println("in test model map "+modelMap);//{}
			//add the results(model attributes)
			modelMap.addAttribute("ts", LocalDateTime.now())
			.addAttribute("number_list", List.of(10,20,30,40));
			System.out.println(modelMap);//{populated map});
			return "/test/test2";//AVN - /WEB-INF/views/test/test2.jsp
		}


}
