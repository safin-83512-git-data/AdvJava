package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

public class BlogPostDaoImpl implements BlogPostDao {

	@Override
	public String createNewPost(BlogPost newPost, 
			Long categoryId, Long bloggerId) {
		String mesg = "adding new post failed !!!!!!!!!!";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// get category ref from it's id
			Category category = session.get(Category.class, categoryId);
			//get blogger from it's id
			User blogger=session.get(User.class, bloggerId);
			if (category != null && blogger != null) {
				// category : persistent n blogger : persistet
				// establish bi dir asso between Category n blog post
				category.addBlogPost(newPost);// modifying the state of PERSISTENT Entity
				//establish uni dir association between BlogPost *--->1 User
				newPost.setBlogger(blogger);
			//blogger id will be set as a Fk
				// session.persist(newPost); NO longer required : since cascading is added !
				mesg = "Added new blog post to the category !";
			}
			tx.commit();// Hibernate performs - auto dirty checking -sees new blog post entity -> insert
						// query
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}
	
	@Override
	public String removeBlog(Long catId, Long blogId) {
		String mesg = "removing blog failed";
		String deleteJPQL="delete from Comment c where c.post.id=:id";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
	//3. get category from its id
			Category category=session.get(Category.class, catId);
			//4. get blog post from it's id
			BlogPost post=session.get(BlogPost.class, blogId);
			if(category != null && post != null)
			{
				//delete child recs(comments)
				int rows=session.createQuery(deleteJPQL)
						.setParameter("id",blogId)
						.executeUpdate();				
				category.removeBlogPost(post);
				mesg="removed blog post along with comments "+rows;
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}


}
