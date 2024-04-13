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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.entity.VideoLecture;
import com.education.model.Response2;
import com.education.model.ResponseWithList;
import com.education.model.VideoLectureDTO;
import com.education.services.VideoLectureService;

import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="Video-API")
public class VideoLectureController {

	@Autowired
	private VideoLectureService videoLectureService;
	
	@PostMapping(value="/uploadVideo",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<?> uploadVideo(@ModelAttribute VideoLectureDTO videoLectureDTO)
	{
		String r=videoLectureService.saveVideoLecture(videoLectureDTO);
		if("Success".equals(r))
		{
			return Response2.generateResponse("Videos are get uploaded", HttpStatus.OK,"200");
		}
		else
		{
			return Response2.generateResponse("No video is there",HttpStatus.INTERNAL_SERVER_ERROR,"500");
		}
	}
	
	@GetMapping(value="stream/{videoId}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable  Long videoId)
	{
		byte[] videoBytes=videoLectureService.getVideoById(videoId);
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		header.setContentDispositionFormData("filename", "video.mp4");
		ByteArrayInputStream stream=new ByteArrayInputStream(videoBytes);
		return new ResponseEntity<>(new InputStreamResource(stream),header,HttpStatus.OK);
	}
	@GetMapping(value="/chapter/{chapterCode}")
	public ResponseEntity<Object> getVideosByChapter(@PathVariable("chapterCode")  String chapterCode)
	{
		List<VideoLecture> v=videoLectureService.getVideosByChapter(chapterCode);
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "200", v);
	}
	
	@GetMapping(value="findVideo")
	public ResponseEntity<?> getAllVideo()
	{
		List<VideoLecture> v=videoLectureService.getAllVideo();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",v);
	}
	
}
