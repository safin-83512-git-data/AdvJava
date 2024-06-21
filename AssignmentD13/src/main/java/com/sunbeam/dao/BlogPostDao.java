package com.sunbeam.dao;
import java.util.List;
import com.sunbeam.entities.BlogPost;

public interface BlogPostDao {
//add  a method to return list of blog post by specified category name
	List<BlogPost> getBlogPostByCategory(String categoryName);
}
