package com.education.services;
import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.education.entity.VideoLecture;
import com.education.model.VideoLectureDTO;
import com.education.repository.VideoLectureRepo;

@Service
public class VideoLectureService
{
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VideoLectureService.class);
	
	@Autowired
	private VideoLectureRepo videoLectureRepo;
	
	public String saveVideoLecture(@ModelAttribute VideoLectureDTO videoLectureDTO)
	{
		try
		{
		VideoLecture videoLecture=new VideoLecture();
		videoLecture.setVideoName(videoLectureDTO.getFile().getOriginalFilename());
		//videoLecture.setClassCode(videoLectureDTO.getClassCode());
		videoLecture.setTitle(videoLectureDTO.getTitle());
		videoLecture.setDescription(videoLecture.getDescription());
		videoLecture.setChapterCode(videoLectureDTO.getChapterCode());
		videoLecture.setClassCode(videoLectureDTO.getClassCode());
		videoLecture.setVideoData(videoLectureDTO.getFile().getBytes());
		videoLectureRepo.save(videoLecture);
		return "Success";
		} catch(Exception e)
		{
			log.error("There is error for saving the video name : {}" ,e.getMessage());
			return "Error";
		}
	
		//videoLecture.setDescription(videoLectureDTO.ge);
	}
	public  byte[]  getVideoById(Long videoId)
	{
		
		Optional<VideoLecture> videoOptional=videoLectureRepo.findById(videoId);
		VideoLecture video=videoOptional.get();
		return video.getVideoData();
	}
	public List<VideoLecture> getVideosByChapter(String chapterCode)
	{
		List<VideoLecture> videos=videoLectureRepo.findByChapterCode(chapterCode);
		for(VideoLecture video: videos)
		{
			video.setVideoData(null);
		}
		return videos;
	}
	public List<VideoLecture> getAllVideo()
	{
		return videoLectureRepo.findAll();
	}
}