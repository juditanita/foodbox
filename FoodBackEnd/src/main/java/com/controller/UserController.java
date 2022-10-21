package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.user.SignUpResponseDto;
import com.dto.user.SignupDto;
import com.exceptions.CustomException;
import com.repo.UserRepository;
import com.service.UserService;



@RequestMapping("user")
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;

	@Autowired
    UserService userService;
	
	@PostMapping("/signup")
    public SignUpResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);
    }
}
