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
public class VideoLectureDTO {

	
	public Long videoId;
	public String title;
	public String classCode;
	public MultipartFile file;
	//public String videoPath;
}
