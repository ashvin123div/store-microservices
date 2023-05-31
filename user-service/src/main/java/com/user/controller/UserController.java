package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.user.entity.User;
import com.user.payload.LoginRequest;
import com.user.payload.LoginResponse;
import com.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(
			@Valid @RequestBody User user,BindingResult bindingResult) {
		log.info("create user method {}");
		if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.add(fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
		return new ResponseEntity<User>(userService.save(user),
				HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(
			@Valid @RequestBody LoginRequest loginRequest, BindingResult bindingResult) {
		log.info("create user method {}");
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errors.add(fieldError.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);
		}
		return new ResponseEntity<LoginResponse>(userService.loginUser(loginRequest),
				HttpStatus.OK);
	}
}
