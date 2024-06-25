package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostReqDTO;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {
	// depcy
	@Autowired
	private BlogPostDao blogPostDao;
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private UserDao userDao;

	@Override
	public ApiResponse postNewBlog(BlogPostReqDTO requestDTO) {
		// 1. get category from it's id
		Category category = categoryDao.findById(requestDTO.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
		// 2. get user(blogger) from it's id
		User blogger = userDao.findById(requestDTO.getAuthorId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid blogger id!!!"));
		// => category , blogger - exists -PERSISTENT
		// 2.5 map dto -> entity
		BlogPost blogPost = mapper.map(requestDTO, BlogPost.class);
		// 3. category 1<--->* post (establish bi dir asso)
		category.addBlogPost(blogPost);
		// 4. blogger 1<---* post (establish uni dir asso)
		blogPost.setBlogger(blogger);
		// 5. save blog post
		BlogPost periststentBlog = blogPostDao.save(blogPost);
		return new ApiResponse("New Blog added with ID=" + periststentBlog.getId());
	}

}
