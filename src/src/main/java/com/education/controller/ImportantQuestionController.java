package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.model.ImportantQuestionDTO;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.services.ImportantQuestionsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="IQ-API")
public class ImportantQuestionController {

	
	
	@Autowired
	private ImportantQuestionsService importantQuestionsService;
	
	@PostMapping(value="/addImportantQuestionPaper",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary="to add the important question paper",description="this api is used to add the important question paper")
	public ResponseEntity<?> addImportantQuestion(@ModelAttribute ImportantQuestionDTO importantQuestionDTO)
	{
		ImportantQuestionDTO savedDTO=importantQuestionsService.saveImportantQuestion(importantQuestionDTO);
		if(savedDTO!=null)
		{
			return new ResponseWithObject().generateResponse("Important Questions are saved",HttpStatus.OK,"200",savedDTO);
			
		}
		else
		{
			return new ResponseWithObject().generateResponse("Important questions are not saved",HttpStatus.BAD_REQUEST,"400","");
		}
	}
	@GetMapping(value="/getImportantQuestion")
	public ResponseEntity<?> getImportantQuestion()
	{
		List<ImportantQuestionDTO> p=importantQuestionsService.getAllImportantQuestion();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",p);
	}
	
	
}
