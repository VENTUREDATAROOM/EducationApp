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
public class PreviousYearQuestionsDTO {
	
	
	private Long id;
	//private String name;
	private String masterCode;
	private MultipartFile pdfFile;
	private String basePreviousPdfFile;
	private String year;
	//private String type;

}
