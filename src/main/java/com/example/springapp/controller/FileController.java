package com.example.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springapp.model.UploadFileResponse;
import com.example.springapp.servies.FileStorageService;

@RestController
public class FileController {
	
	@Autowired
	private FileStorageService fileStorageService;
	
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		String fileNameString = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile")
				.path(fileNameString)
				.toUriString();
		return new UploadFileResponse(fileNameString, fileDownloadUri, file.getContentType(), file.getSize());
		
	}
	
}
