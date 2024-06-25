package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentRequest {
	/*
	 * comment text , rating , commenter id , blog post id
	 * 
	 */
	private String commentText;
	private int rating;
	private Long commenterId;
	private Long blogPostId;
}
