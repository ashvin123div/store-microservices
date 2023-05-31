package com.user.service;


import com.user.entity.User;
import com.user.payload.LoginRequest;
import com.user.payload.LoginResponse;

public interface UserService {

	User save(User user);
	LoginResponse loginUser(LoginRequest loginRequest);
}
