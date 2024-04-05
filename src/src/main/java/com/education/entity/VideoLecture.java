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
public class VideoLecture {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long videoId;
	private String title;
	private String classCode;
	private String videoName;
	private byte[] videoData;
	//private String videoPath;
	
}
