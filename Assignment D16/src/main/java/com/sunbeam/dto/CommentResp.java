package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResp extends BaseDTO {
/*
 * comment id , text , rating , created on , updated on 

 */
	private String commentText;
	private int rating;
}
