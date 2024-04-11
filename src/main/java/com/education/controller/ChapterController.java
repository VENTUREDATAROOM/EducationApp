package com.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.model.ChapterDTO;
import com.education.model.Response2;
import com.education.services.ChapterService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="CHAPTER-API")

public class ChapterController {

	
	@Autowired
	private ChapterService chapterService;
	
	@PostMapping(value="/addChapter")
	public ResponseEntity<?> addChapter(@RequestBody ChapterDTO chapterDTO)
	{
		String c=chapterService.saveChapter(chapterDTO);
		if("Success".equals(c))
		{
			return Response2.generateResponse("Chapter are saved", HttpStatus.OK, "200");
		}
		else
		{
			return Response2.generateResponse("No chapter are saved", HttpStatus.BAD_REQUEST, "400");
		}
	}
}
