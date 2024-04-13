package com.education.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name="chapter_details")
public class ChapterEntity {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="class_id")
	private Long chapterId;
	@Column(name="chapter_name")
	private String chapterName;
	@Column(name="chapter_description")
	private String chapterDescription;
	@Column(name="class_code")
	private String classCode;
	@Column(name="chapter_code")
	private String chapterCode;
	//@OneToMany(mappedBy="chapter_details",cascade=CascadeType.ALL)
	//private List<VideoLecture> videoLecture;
}
