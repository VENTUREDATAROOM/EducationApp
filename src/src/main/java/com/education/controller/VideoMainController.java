/*package com.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.education.model.ResponseWithObject;
import com.education.model.VideoMainDTO;
import com.education.services.VideoMainService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class VideoMainController {

	
	@Autowired
	private VideoMainService videoMainService;
	
	
	
	@GetMapping("value=/getAllVideo")
	public ResponseEntity<Object> getAllVideo()
	
	{
		Flux<VideoMainDTO> t=videoMainService.getAllVideo();
		return new ResponseWithObject().generateResponse("provide",HttpStatus.OK,"200",t);
		
		
	}
	
	
	@GetMapping(value="/getVideoStream/{title}")
	//@GetMapping(value="/stream/{classCode}")
	public Mono<VideoMainDTO> getVideoStream(@PathVariable String id)
	{
		return videoMainService.getVideoById(id);
	}
	
	public Mono<ResponseEntity<String>> saveVideo(@RequestBody VideoMainDTO videoMainDTO)
	{
		//if(response!=n)
		Mono<String> response=videoMainService.saveVideo(videoMainDTO);
		if(response!=null)
		{
			return new ResponseWithObject().generateResponse("Video is saved successfully", HttpStatus.OK, "200", response);
		}
		else
		{
			return new ResponseWithObject().generateResponse("Video is not saved successfully", HttpStatus.BAD_REQUEST,"400","");
		}
	}
	
	
	
}*/
