package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostReqDTO;

public interface BlogPostService {
ApiResponse postNewBlog(BlogPostReqDTO requestDTO);
}
