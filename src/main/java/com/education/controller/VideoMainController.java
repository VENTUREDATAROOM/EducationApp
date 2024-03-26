//package com.education.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.education.model.Response2;
//import com.education.services.VideoMainService;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//
//@RestController
//@CrossOrigin(origins="*")
//@RequestMapping("api")
//@Tag(name="VideoMain-API")
//public class VideoMainController {
//
//	@Autowired
//	private VideoMainService videoMainService;
//	public ResponseEntity<?> uploadVideo(@RequestParam ("video") MultipartFile videoMain, @RequestParam ("name") String name, @RequestParam ("type") String type)
//	{
//		    String res=videoMainService.saveVideo(videoMain, name, type);
//		    if("Success".equals(res))
//		    {
//		    	return Response2.generateResponse("Videos are saved", HttpStatus.OK, "200");
//		    }
//		    else
//		    {
//		    	return Response2.generateResponse("Videos are not saved", HttpStatus.BAD_REQUEST, "400");
//		    }
//	}
//}
