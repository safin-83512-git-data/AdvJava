package com.sunbeam.service;

import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserRespDTO;

public interface UserService {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);
}
