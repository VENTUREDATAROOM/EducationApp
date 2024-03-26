package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.entity.PreviousYearQuestions;
import com.education.model.PreviousYearQuestionsDTO;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.services.PreviousYearQuestionsService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
@Tag(name="PYQ-API")
public class PreviousYearQuestionController {

	@Autowired
	private PreviousYearQuestionsService previousYearQuestionsService;
	@PostMapping(value="/addPreviousYearQuestionPaper")
	public ResponseEntity<?> addMainQuestionPaper(@RequestBody PreviousYearQuestionsDTO previousYearQuestionsDTO)
	{
		PreviousYearQuestionsDTO response=previousYearQuestionsService.saveQuestionPaper(previousYearQuestionsDTO);
		return new ResponseWithObject().generateResponse("Questions are saved successfully",HttpStatus.OK,"200",response);
	}
	
	@GetMapping(value="/getAllQuestionPaper/{type}")
	public ResponseEntity<?> getMainQuestionPaper(@PathVariable String type)
	{
		List<PreviousYearQuestions> t=previousYearQuestionsService.getAllQuestionPaper(type);
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",t);
	}
	
}
