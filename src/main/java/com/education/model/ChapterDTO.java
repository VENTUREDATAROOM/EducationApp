package com.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChapterDTO {

	
	private Long chapterId;
	//private String classDescription;
	private String  chapterName;
	private String chapterDescription;
	private String classCode;
	private String chapterCode;
}
