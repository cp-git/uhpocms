package com.cpa.uhpocms.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/uhpocms")
public class UploadController {

	private String basePath = "H:/uhpocmsUpload/course";

	@PostMapping("/file/upload")
	public ResponseEntity<List<String>> uploadFile(@RequestParam("files") List<MultipartFile> files)
			throws IOException {

		List<String> fileNames = new ArrayList<>();

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			Path fileStorage = Paths.get(basePath, fileName).toAbsolutePath().normalize();
			Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);
			fileNames.add(fileName);
		}
		return ResponseEntity.ok().body(fileNames);
	}
}
