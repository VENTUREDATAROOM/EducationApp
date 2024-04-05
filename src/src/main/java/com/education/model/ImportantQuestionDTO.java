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
public class ImportantQuestionDTO {

	
	private Long importantQuestionsId;
	private String classCode;
	private MultipartFile importantQuestionPdf;
	private String baseImportantQuestionPdf;
}
