package com.education.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="quiz_details")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
