package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.education.entity.PreviousYearQuestions;
import com.education.model.PreviousYearQuestionsDTO;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.services.PreviousYearQuestionsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
@Tag(name="PYQ-API")
public class PreviousYearQuestionController {

	@Autowired
	private PreviousYearQuestionsService previousYearQuestionsService;
	@PostMapping(value="/addPreviousYearQuestionPaper",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE},produces=MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary="add previous year question paper",description="this api is used to add previous year question paper")
	public ResponseEntity<?> addQuestionPaper(@ModelAttribute PreviousYearQuestionsDTO previousYearQuestionsDTO)
	{
		PreviousYearQuestionsDTO response=previousYearQuestionsService.saveQuestionPaper(previousYearQuestionsDTO);
		return new ResponseWithObject().generateResponse("Questions are saved successfully",HttpStatus.OK,"200",response);
	}
	
	@GetMapping(value="/getAllQuestionPaper")
	@Operation(summary="to get all the question paper",description="this api is used to get all the question paper")
	public ResponseEntity<?> getAllQuestionPaper()
	{
		List<PreviousYearQuestionsDTO> t=previousYearQuestionsService.getQuestion();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",t);
	}
	@GetMapping(value="/getPreviousPaperByMasterCode")
	@Operation(summary="to get the question by mastercode",description="this api is to get the question by classcode")
	public ResponseEntity<?> getQuestionByMasterCode(@RequestParam ("masterCode") String masterCode)
	{
		List<PreviousYearQuestionsDTO> p=previousYearQuestionsService.getQuestionByMasterCode(masterCode);
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "200", p);
	}
	
}
