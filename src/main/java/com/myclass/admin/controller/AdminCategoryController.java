package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@RestController
@RequestMapping("api/admin/category")
public class AdminCategoryController {
	
	private CategoryService categoryService;
	
	public AdminCategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("")
	public Object post(@RequestBody CategoryDto dto) {
		try {
			categoryService.insert(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
