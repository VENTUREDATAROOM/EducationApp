/*package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.education.entity.Videos;
import com.education.model.Response2;
import com.education.model.ResponseWithList;
import com.education.services.VideoService;

import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="Video-API")
public class VideoController {
	
	@Autowired
	private VideoService videoService;
	@PostMapping(value="/addVideo",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> saveVideo(@RequestParam ("video") MultipartFile video, @RequestParam ("classcode") String classCode)
	{
		String res=videoService.addVideoData(video, classCode);
		if("Success".equals(res))
		{
			return Response2.generateResponse("Videos are already saved", HttpStatus.OK, "200");
		}
		else if("Error".equals(res))
		{
			return Response2.generateResponse("Videos are not saved", HttpStatus.INTERNAL_SERVER_ERROR,"500");
		}
		else {
			return Response2.generateResponse("Videos are unable to processed", HttpStatus.BAD_REQUEST, "400");
		}
		//return Response2.generateResponse("Videos are already saved", HttpStatus.OK, "200");
	}
	@GetMapping(value="/getAllVideo")
	public ResponseEntity<?> getAllVideo()
	{
		List<Videos> t=videoService.getAllVideo();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",t);
	}
   public ResponseEntity<?> getVideoByClassCode(@RequestParam String classCode)
   {
	   List<Videos> t=videoService.getVideosByClassCode(classCode);
	   return new ResponseWithList().generateResponse(classCode, HttpStatus.OK, "200", t);
   }
	
	
}*/
//package com.education.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.education.entity.VideoLecture;
//import com.education.model.VideoLectureDTO;
//import com.education.services.VideoLectureService;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import reactor.core.publisher.Flux;
////import reactor.core.publisher.Mono;
//import reactor.core.publisher.Mono;
//
//@RestController
//@CrossOrigin(origins="*")
//@RequestMapping("api")
//@Tag(name="Video-API")
//public class VideoController {
//
//    @Autowired
//    private VideoLectureService videoService;
//
//    /*@GetMapping(value="/stream/{classCode}")
//    public Flux<byte[]> streamVideo(@PathVariable String classCode) {
//        return videoService.streamVideoLectures(classCode);
//    }*/
//    @PostMapping(value="/videoLectures")
//    public Mono<ResponseEntity<VideoLecture>> createVideoLecture(@RequestBody VideoLectureDTO videoLectureDTO)
//    {
//    	
//    	
//    }
//}
