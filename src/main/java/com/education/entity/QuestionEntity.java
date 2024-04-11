package com.education.entity;

import javax.persistence.Column;
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
@Table(name="questions_details")
public class QuestionEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="question_id")
	private Long questionId;
	@Column(name="question_Title")
	private String questionTitle;
	@Column(name="option_1")
	private String option1;
	@Column(name="option_2")
	private String option2;
	@Column(name="option_3")
	private String option3;
	@Column(name="option_4")
	private String option4;
    @Column(name="right_answer")
	private String rightAnswer;
    @Column(name="difficulty_level")
	private String difficultyLevel;
    @Column(name="category")
    private String category;

}
