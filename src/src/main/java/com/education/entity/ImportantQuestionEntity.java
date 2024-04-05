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
@Table(name="important_question")
public class ImportantQuestionEntity {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long importantQuestionId;
	private String classCode;
	private byte[] questionPdf;
}
