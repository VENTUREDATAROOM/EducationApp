//package com.education.services;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
//import com.education.entity.VideoMainEntity;
//import com.education.model.VideoMainDTO;
//import com.education.repository.VideoMainRepo;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//public class VideoMainService {
//	
//	@Autowired
//	private VideoMainRepo videoMainRepo;
//	
//	
////	public Mono<String> saveVideo(FilePart fike)
//	
//	@Autowired
//	private ModelMapper mapper;
//	//private ResourceLoader resourceLoader;
//	//private String classpath;(
//	
//	
//	public Mono<String> saveVideo(VideoMainDTO videoMainDTO)
//	{
//		VideoMainEntity videoMainEntity=mapper.map(videoMainDTO, VideoMainEntity.class);
//		videoMainRepo.save(videoMainEntity);
//		return 
//	}
//	
//	public Flux<VideoMainDTO> getAllVideo()
//	{
//		return videoMainRepo.findAll().map(this::convertToDTO);
//	}
//	public Mono<VideoMainDTO> getVideoById(String id)
//	{
//		return videoMainRepo.findById(id).map(this::convertToDTO);
//	}
//	
//	/*public Mono<Resource> getVideoStream(String title)
//	{
//		
//		return Mono.fromSupplier(()->resourceLoader.getResource(String.format(title, classpath)));
//	}*/
//	private VideoMainDTO convertToDTO(VideoMainEntity videoMainEntity)
//	{
//		return new VideoMainDTO(videoMainEntity.getId(),videoMainEntity.getMasterCode(),videoMainEntity.getYear(),videoMainEntity.getVideoPath());
//	}
//	
//
//}
