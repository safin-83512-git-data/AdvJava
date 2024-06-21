package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // spring bean containing req handling logic
//singleton n eager
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("in ctor "+getClass());
	}
	//add rq handling method to render welcome resp to the clnt
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";//Handler rets LVN -> D.S -> V.R -> AVN
		//AVN : /WEB-INF/views/welcome.jsp
	}
	//add rq handling method to render index page to the clnt
	@GetMapping("/")//=@RequestMapping(method=GET) => doGet
	public String renderIndexPage() {
		System.out.println("in render index page");
		return "/index";//AVN -/WEB-INF/views/index.jsp 
	}

	

}
