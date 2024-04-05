package com.education.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="quiz_details")
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long quizId;
	private String title;
	private String description;
	private int maxMarks;
	//private String classCode;
	private int noOfQuestions;
	@JsonIgnore
	@OneToMany(mappedBy="quiz",fetch=FetchType.LAZY)
	private Set<Question> question;
	
	
	
	
}
