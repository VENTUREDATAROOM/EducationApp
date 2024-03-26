package com.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.Videos;

public interface VideosRepo extends JpaRepository <Videos,Long> 
{
 List<Videos>  findByClassCode(String classCode);
}
