package com.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class QuizDTO {

	
	private Long questionId;
	private String questionText;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;
	private String wrongAnswer;
	private String category;
	
	
}
