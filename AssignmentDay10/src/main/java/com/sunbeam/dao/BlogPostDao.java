package com.sunbeam.dao;

import com.sunbeam.entities.BlogPost;

public interface BlogPostDao {

	String createNewPost(BlogPost newPost, Long  categoryId,Long bloggerId);
	String removeBlog(Long catId, Long blogId);
}
