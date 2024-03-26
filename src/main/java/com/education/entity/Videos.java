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
@Table(name="video_name")
public class Videos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long videoId;
	private byte[] videoNames;
	private String classCode;
	
}
