package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Comment;

public interface CommentDao {
//post new comment
	String postNewComment(Comment newComment, Long commenterId, Long postId);

//list all comments by given blog post title
	List<Comment> getCommentsByPost(String postTitle);
}
