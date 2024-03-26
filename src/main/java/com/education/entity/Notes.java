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
@Table(name="notes")
public class Notes {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long notesId;
	private String noteNames;
	private String classCode;
	private byte[] notesPdf;
	
	
}


