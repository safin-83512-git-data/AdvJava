package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.CommentRequest;
import com.sunbeam.dto.CommentResp;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	// depcy
	@Autowired
	private CommentDao commentDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private BlogPostDao blogPostDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CommentResp postNewComment(CommentRequest dto) {
		// get commenter from the id
		User commenter = userDao.findById(dto.getCommenterId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid commenter id"));
		// chk role - extra validation (will disappear after spring sec authorization!)
		if (commenter.getRole() != Role.COMMENTER)
			throw new ApiException("Invalid Role !!!");
		// get blog post from id
		BlogPost post = blogPostDao.findById(dto.getBlogPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid blog post id !!!"));
		//a blogger can't comment on their own post
		if(commenter.getId() == post.getBlogger().getId())
			throw new ApiException("You can't comment on your own post !!!!");
		//all valid 
		Comment comment = mapper.map(dto, Comment.class);
		//establish asso
		comment.setCommenter(commenter);
		comment.setPost(post);
		//save the comment
		Comment persistentComment = commentDao.save(comment);
		
		return mapper.map(persistentComment, CommentResp.class);
	}

}
