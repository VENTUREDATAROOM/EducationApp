package com.education.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.education.entity.VideoLecture;
import com.education.model.VideoLectureDTO;
import com.education.model.VideoMainDTO;
import com.education.repository.VideoLectureRepo;

@Service
public class VideoLectureService
{
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VideoLectureService.class);
	@Autowired
	private VideoLectureRepo videoLectureRepo;
	
	 @Autowired
	private ModelMapper mapper;
	public String saveVideo(VideoLectureDTO videoLectureDTO)
	{
		try
		{
		VideoLecture videoLecture=new VideoLecture();
		videoLecture.setClassCode(videoLectureDTO.getClassCode());
		videoLecture.setVideoData(videoLectureDTO.getFile().getBytes());
		videoLecture.setTitle(videoLectureDTO.getTitle());
		 videoLecture.setVideoName(videoLectureDTO.getFile().getOriginalFilename());
		 videoLectureRepo.save(videoLecture);
		 
		//videoLecture.setVideoId(videoDTO.ge);
		return "Success";
		} catch(Exception e)
		{
			e.printStackTrace();
			log.error("There is an error for saving the videos {} ",e.getMessage());
			return "Error";
		}
	}
	public  byte[]  getVideoById(Long videoId)
	{
		
		Optional<VideoLecture> videoOptional=videoLectureRepo.findById(videoId);
		VideoLecture video=videoOptional.get();
		return video.getVideoData();
	}
	public List<VideoLectureDTO> getAllVideo()
	{
		List<VideoLecture> t=videoLectureRepo.findAll();
		return t.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	public VideoLectureDTO convertToDTO(VideoLecture videoLecture)
	{
		return  mapper.map(videoLecture,VideoLectureDTO.class);
	}
}

