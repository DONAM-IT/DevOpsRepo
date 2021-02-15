package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<CategoryDto> getAll() {
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		
		List<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			categoryDtos.add(new CategoryDto(
						category.getId(),
						category.getTitle(),
						category.getIcon()
					));
		}
		return categoryDtos;
	}

	@Override
	public void insert(CategoryDto dto) {
		Category category = new Category();
		category.setTitle(dto.getTitle());
		category.setIcon(dto.getIcon());
		categoryRepository.save(category);
	}

}
