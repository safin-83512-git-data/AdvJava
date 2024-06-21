package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/posts")
public class BlogPostController{
	@Autowired
	private BlogPostController blogPostController;
	
	private BlogPostController() {
		System.out.println("in ctor" + getClass());
	}
	@GetMapping("/view")
	public String getBlogPostByCategory(@RequestParam String categoryName, Model modelAttributeMap)
{
		System.out.println("in get blog posts" + categoryName);
		//invoke service method
		modelAttributeMap.addAttribute("blog_list", blogPostController.getPostsByCategoryName(categoryName));
		return "/posts/view"; //AVN = /WEB-INF/ views/ posts/ view.jsp
		
		}
	private Object getPostsByCategoryName(String categoryName) {
		return null;
	}
}

