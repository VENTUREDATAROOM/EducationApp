package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.VideoLecture;

public interface VideoLectureRepo extends JpaRepository<VideoLecture,Long>
{
	
}