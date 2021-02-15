package com.myclass.admin.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.service.FileService;

@RestController
@RequestMapping("api/admin/file")
public class AdminFileController {
	
	private FileService fileService;
	
	public AdminFileController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@PostMapping("upload")
	public Object upload(@RequestParam MultipartFile file) {
		try {
			String fileName = fileService.saveFile(file);
			return new ResponseEntity<Object>(fileName, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
