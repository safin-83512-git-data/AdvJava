package com.sunbeam.dao;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.BlogPost;

@Repository
public class BlogPostDaoImpl implements BlogPostDao {
@Autowired
private SessionFactory factory;

@Override
public List<BlogPost> getBlogPostByCategory(String categoryName){
	String jpql = "select p from BlogPost p where  p.selectedCategory.categoryName =:cat";
			return factory.getCurrentSession().createQuery(jpql, BlogPost.class).setParameter("cat", categoryName).getResultList();
}

}
