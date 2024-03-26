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
@Table(name="class_table")
public class ClassEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long classId;
	private String classname;
	private String classdescription;
	private String classCode;

}
