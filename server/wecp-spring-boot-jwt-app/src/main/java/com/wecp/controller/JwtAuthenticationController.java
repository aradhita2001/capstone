package com.wecp.controller;

import java.util.Objects;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wecp.config.JwtTokenUtil;
import com.wecp.model.JwtRequest;
import com.wecp.model.JwtResponse;

public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		final UserDetails userDetails = null;
		/**
		 * @todo fetch the userDetails object from db
		 */
		if(userDetails == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		/**
		 * Do password match. if password doesn't match, return from the method without returning the token
		 * 
		 */

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(UserDetails userDetails) throws Exception {
		Objects.requireNonNull(userDetails);
		Objects.requireNonNull(userDetails.getUsername());
		Objects.requireNonNull(userDetails.getPassword());
		

	}
}
