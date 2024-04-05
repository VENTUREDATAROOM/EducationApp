package com.education.model;

import java.util.Set;

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
public class QuizDTO {

	
//	private Long questionId;
//	private String questionText;
//	private String option1;
//	private String option2;
//	private String option3;
//	private String option4;
//	private String correctAnswer;
//	private String wrongAnswer;
//	private String category;
	private Long quizId;
	private String title;
	private String description;
	//private String classCode;
	private int noOfQuestions;
	private int maximumMarks;
	private Set<QuestionDTO> questionDTO;
	
	
	
}
