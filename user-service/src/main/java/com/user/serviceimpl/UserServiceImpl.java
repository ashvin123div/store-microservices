package com.user.serviceimpl;

import java.util.Date;
import java.util.Objects;

import com.user.entity.User;
import com.user.exception.ValidationException;
import com.user.payload.LoginRequest;
import com.user.payload.LoginResponse;
import com.user.repository.UserRepository;
import com.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public User save(User user) {
		user.setId(null);
		user.setCreateDate(new Date());
		user.setPassword("12345");
		if(Objects.nonNull(userRepository.findUserByUserName(user.getUserName()))) {
			throw new ValidationException("User already exist", HttpStatus.FOUND);
		}
		return userRepository.save(user);
	}

	@Override
	public LoginResponse loginUser(LoginRequest loginRequest) {
		LoginResponse loginResponse=new LoginResponse();
		User user=userRepository.findUserByUserName(loginRequest.getUserName());
		if(Objects.isNull(user)) {
			throw new ValidationException("Username or Password Wrong", HttpStatus.BAD_REQUEST);
		}
		loginResponse.setUserName(user.getUserName());
		loginResponse.setId(user.getId());
		return loginResponse;
	}

}
