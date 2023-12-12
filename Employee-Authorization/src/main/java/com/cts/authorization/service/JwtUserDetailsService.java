package com.cts.authorization.service;

import com.cts.authorization.controller.JwtAuthenticationController;
import com.cts.authorization.feign.DoctorServiceFeignClient;
import com.cts.authorization.feign.PatientServiceFeignClient;
import com.cts.authorization.model.JwtRequest;
import com.cts.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.authorization.model.MyUserDetails;
import com.cts.authorization.model.User;

import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@Service @Slf4j
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) {
		User user = userRepository.findById(userName).get();
		if (!userRepository.findById(userName).isPresent()) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		return new MyUserDetails(user);
	}

	public User addLoginDetails(User user){
		return userRepository.save(user);
	}

}