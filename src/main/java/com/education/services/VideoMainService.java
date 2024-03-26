//package com.education.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.education.entity.VideoMainEntity;
//import com.education.repository.VideoMainRepo;
//@Service
//public class VideoMainService {
//	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VideoMainService.class);
//	
//	@Autowired
//	private VideoMainRepo  videoMainRepo;
//
//	 public String  saveVideo(MultipartFile videoMain,String name, String type)
//	 {
//		 try
//		 {
//			 VideoMainEntity videoMainEntity=new VideoMainEntity();
//			 videoMainEntity.setName(name);
//			 videoMainEntity.setType(type);
//			 videoMainEntity.setVideoData(videoMain.getBytes());
//			return "Success"; 
//		 } catch(Exception e)
//		 {
//			 log.error("There is an error for video processing : {}",e.getMessage());
//			 return "Error";
//		 }
//	 }
//	 
//}
