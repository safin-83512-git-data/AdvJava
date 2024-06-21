package com.sunbeam.service;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.entities.BlogPost;
@Service
@Transactional

public class BlogPostServiceImpl implements BlogPostService{

	@Autowired
	private BlogPostDao blogPostDao;
	
	@Override
	public List<BlogPost> getPostsByCategoryName(String catName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
