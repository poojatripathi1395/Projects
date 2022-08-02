package com.example.demo.springsecurity.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springsecurity.jwt.model.AuthenticationRequest;
import com.example.demo.springsecurity.jwt.model.AuthenticationResponse;
import com.example.demo.springsecurity.jwt.serviceImpl.UserDetailServiceImpl;
import com.example.demo.springsecurity.jwt.util.JwtUtil;

@RestController
public class HelloResourceController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserDetailServiceImpl UserDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;
	
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Pooja";
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
    	try {
    	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
    }
    	catch(BadCredentialsException e) {
    		throw new Exception("Invalid userName or password",e);
    	}
    	final UserDetails userDetails = UserDetailsService
    			.loadUserByUsername(authenticationRequest.getUserName());
    	final String jwt = jwtTokenUtil.generateToken(userDetails);
    	return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    
}
