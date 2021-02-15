package com.myclass.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("api/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PutMapping("{id}/{avatar}")
	public Object put(@PathVariable int id, @PathVariable String avatar) {
		try {
			userService.changeAvatar(id, avatar);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("")
	public Object get(@PathVariable String token) {
		try {
			// GIẢI MÃ TOKEN LẤY EMAIL
			String email = Jwts.parser()
					.setSigningKey("ABC_EGH")
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			
			UserDto userDto = userService.getByEmail(email);
			return new ResponseEntity<Object>(userDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
