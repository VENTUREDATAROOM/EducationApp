package com.education.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="video_main_entity")
public class VideoMainEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String masterCode;
	private String videoName;
	@Lob
	private byte[] videoData;
	private String year;

}
