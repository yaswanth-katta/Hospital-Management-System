package com.cts.authorization.controller;

import com.cts.authorization.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.cts.authorization.config.JwtTokenUtil;
import com.cts.authorization.exception.AuthorizationException;
import com.cts.authorization.model.JwtRequest;
import com.cts.authorization.service.JwtUserDetailsService;

@RestController @Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	public String role;
	public JwtRequest jwtRequest=new JwtRequest();

	/**
	 * @param authenticationRequest
	 * @return
	 * @throws AuthorizationException
	 * @throws Exception
	 */
	@PostMapping(value = "/authenticate")
	public String createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws AuthorizationException {
		 authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		return jwtTokenUtil.generateToken(userDetails);


	}
	@PostMapping(value = "/addLoginDetalils")
	public User addLoginDetails(@RequestBody User user){
		return userDetailsService.addLoginDetails(user);
	}


	private void  authenticate(String userName, String password) throws AuthorizationException {
		try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));

		} catch (DisabledException e) {
			throw new AuthorizationException("USER_DISABLED");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new AuthorizationException("INVALID_CREDENTIALS");
		}

	}

	/**
	 * @param requestTokenHeader
	 * @return
	 */
	@GetMapping(value = "/authorize")
	public boolean authorizeTheRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
		String jwtToken = null;
		String userName = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (Exception e) {
				return false;
			}
		}
		return userName != null;

	}


}