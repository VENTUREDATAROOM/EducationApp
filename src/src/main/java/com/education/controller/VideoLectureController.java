package com.education.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.education.entity.VideoLecture;
import com.education.model.Response2;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.model.VideoLectureDTO;
import com.education.model.VideoMainDTO;
import com.education.services.VideoLectureService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="Video-API")
public class VideoLectureController {

	
	@Autowired
	private VideoLectureService videoLectureService;
	
	@PostMapping(value="/addVideo",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> uploadVideo(@ModelAttribute VideoLectureDTO videoLectureDTO)
	{
		String res=videoLectureService.saveVideo(videoLectureDTO);
		if("Success".equals(res))
		{
			return  Response2.generateResponse("Video are upload successfully", HttpStatus.OK, "200");
			
		}
		else 
		{
			return Response2.generateResponse("No video uploaded", HttpStatus.BAD_REQUEST, "400");
		}
	}
	@GetMapping(value="/streamVideo/{videoId}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable Long videoId)
	{
		byte[] videoBytes=videoLectureService.getVideoById(videoId);
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("filename","video.mp4");
	    ByteArrayInputStream stream=new ByteArrayInputStream(videoBytes);
	    return new ResponseEntity<>(new InputStreamResource(stream),headers,HttpStatus.OK);
	}
	@GetMapping(value="/findVideo",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<?> findVideos()
	{
		List<VideoLectureDTO> v=videoLectureService.getAllVideo();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",v);
	}
}

