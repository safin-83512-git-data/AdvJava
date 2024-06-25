package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.User;

public class CommentDaoImpl implements CommentDao {

	@Override
	public String postNewComment(Comment newComment, Long commenterId, Long postId) {
		String mesg = "adding comment failed ....";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get commenter from the id
			User commenter=session.get(User.class, commenterId);
			//4. get post from its id
			BlogPost post=session.get(BlogPost.class, postId);
			/*
			 * a blogger should NOT be allowed to comment on his/her own blog post 
			 */
			if(commenter != null && post != null 
					&& commenter.getId() != post.getBlogger().getId())
			{
				//=> commenter n post exists !
				//5. establish uni dir associations
				newComment.setCommenter(commenter);
				newComment.setPost(post);
				//6. save the comment
				session.persist(newComment);
				mesg="posted new comment!";
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

	@Override
	public List<Comment> getCommentsByPost(String postTitle) {
		List<Comment> comments = null;
		String jpql="select c from Comment c where c.post.title=:title";
		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			comments=session.createQuery(jpql,Comment.class)
					.setParameter("title",postTitle)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return comments;
	}

}
