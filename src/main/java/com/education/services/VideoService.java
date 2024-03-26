/*package com.education.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.education.entity.Videos;
import com.education.repository.VideosRepo;

@Service
public class VideoService {
	
	
	@Autowired
	private VideosRepo videoRepository;
	   
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(VideoService.class);
	
	public String addVideoData(MultipartFile  video,String classCode) {
		try
		{
			Videos videos=new  Videos();
			
			videos.setClassCode(classCode);
			videos.setVideoNames(video.getBytes());
			
			  videoRepository.save(videos);
			return "Success";
			
		} catch(Exception e)
		{
			log.error("There is an error for videos : {}",e.getMessage());
			return "Error";
		}
		
	}
	public List<Videos> getAllVideo()
	{
		return videoRepository.findAll();
	}
	public List<Videos> getVideosByClassCode(String classCode)
	{
		return videoRepository.findByClassCode(classCode);
	}
	
	
	

}*/
// VideoStreamService class
package com.education.services;

import com.education.entity.Videos;
//import com.ask.home.videostream.model.VideoLecture;
//import com.ask.home.videostream.repository.VideosRepo;
import com.education.repository.VideosRepo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VideoService {

    @Autowired
    private VideosRepo videosRepo;

    public Flux<byte[]> streamVideoLectures(String classCode) {
        return Flux.fromIterable(videosRepo.findByClassCode(classCode))
                .map(Videos::getVideoNames);
    }
   /* public Mono<Void> postVideoLectures(String classCode, Flux<Videos> videos) {
        return videosRepo.saveAll(videos).then();
    }*/
   /* public List<Videos> postVideoLectures(String classCode, Flux<Videos> videos) {
        return videos.collectList()
                .flatMap(videosList -> {
                    Iterable<Videos> videosIterable = videosList.stream().collect(Collectors.toList());
                    return videosRepo.saveAll(videosIterable);
                })
                .then();
    }*/
    /*public Mono<Void> postVideoLectures(String classCode, Flux<Videos> videos) {
        return videos.collectList()
                .flatMap(videosList -> videosRepo.saveAll(videosList))
                .then();
    }*/
}

// VideoStreamController class
/*package com.ask.home.videostream.controller;

import com.ask.home.videostream.service.VideoStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/video")
public class VideoStreamController {

    @Autowired
    private VideoStreamService videoStreamService;

    @GetMapping("/stream/{className}")
    public Flux<byte[]> streamVideo(@PathVariable String className) {
        return videoStreamService.streamVideoLectures(className);
    }
}*/

