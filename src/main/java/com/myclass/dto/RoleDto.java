package com.myclass.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class RoleDto {
	private int id;
	
	@NotEmpty(message = "Vui lòng nhập tên!")
	@Length(min = 4, message = "Tên ít nhất 4 ký tự!")
	private String name;
	
	@NotEmpty(message = "Vui lòng nhập mô tả!")
	private String description;
	
	public RoleDto() {}
	
	public RoleDto(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
