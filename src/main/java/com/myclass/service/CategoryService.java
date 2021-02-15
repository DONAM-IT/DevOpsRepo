package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {
	List<CategoryDto> getAll();
	void insert(CategoryDto dto);
}
