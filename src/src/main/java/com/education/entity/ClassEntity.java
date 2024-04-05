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
@Table(name="class_table")
public class ClassEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="class_id")
	private Long classId;
	@Column(name="class_name")
	private String className;
	@Column(name="description")
	private String classDescription;
	@Column(name="class_code")
	private String classCode;

}
