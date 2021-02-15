package com.myclass.service.impl;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.myclass.dto.LoginDto;
import com.myclass.service.AuthService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthServiceImpl implements AuthService {
	
	private AuthenticationManager authenticationManager;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public String login(LoginDto dto) {
		// ĐĂNG NHẬP LẤY THÔNG TIN USER
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

		// TẠO CHUỖI TOKEN
		Date now = new Date();
		String token = Jwts.builder().setSubject(dto.getEmail()) // GẮN email VÀO TOKEN
				.setIssuedAt(now) // THỜI GIAN PHÁT HÀNH TOKEN
				.setExpiration(new Date(now.getTime() + 864000000L)) // HẠN SỬ DỤNG 10 NGÀY
				.signWith(SignatureAlgorithm.HS512, "ABC_EGH") // THUẬT TOÁN MÃ HÓA
				.compact();
		
		return token;
	}

}
