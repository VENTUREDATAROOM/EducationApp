package com.education.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VideoMainDTO {

	
	private String videoId;
	private String masterCode;
	private String videoName;
	private MultipartFile videoFile;
	private String year;
}
