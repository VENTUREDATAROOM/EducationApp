package com.education.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@Entity
@Table(name="question_fg")

public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	private String classCode;
	private String content;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;
	private String wrongAnswer;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	private QuizEntity quiz;
	
}
