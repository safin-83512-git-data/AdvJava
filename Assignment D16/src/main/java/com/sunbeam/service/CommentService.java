package com.sunbeam.service;

import com.sunbeam.dto.CommentRequest;
import com.sunbeam.dto.CommentResp;

public interface CommentService {
	CommentResp postNewComment(CommentRequest dto);
}
