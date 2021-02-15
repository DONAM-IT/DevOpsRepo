package com.myclass.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String saveFile(MultipartFile file);
}
