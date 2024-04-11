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
@Table(name="video_names")
public class VideoLecture {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long videoId;
	public String videoName;
	public String title;
	public String classCode;
	public String chapterCode;
	public String description;
	public byte[] videoData;
	

}
