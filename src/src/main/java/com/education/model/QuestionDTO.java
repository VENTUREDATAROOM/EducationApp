package com.education.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

	
	private Long questionId;
	private String classCode;
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;
	private String wrongAnswer;
   //private QuizDTO quizDTO;
	
	
}
