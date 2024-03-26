package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.entity.QuizEntity;
import com.education.model.QuizDTO;
import com.education.model.Response2;
import com.education.model.ResponseWithList;
import com.education.services.QuizService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="Quiz-API")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	
	@PostMapping(value="/addQuiz")
	public ResponseEntity<?> addQuiz(@RequestBody QuizDTO quizDTO)
	{
		
		if(!quizDTO.getCorrectAnswer().equals(quizDTO.getWrongAnswer())) 
		{
		String res=quizService.saveQuiz(quizDTO);
		if("Success".equals(res))
		{
			return Response2.generateResponse("Quiz details are saved", HttpStatus.OK, "200");
		}
		//else if("Error".equals(res))
		//{
			//return Response2.generateResponse("Quiz details are not saved", HttpStatus.BAD_REQUEST, "400");
			
		//}
		else
		{
			return Response2.generateResponse("Quiz details are not provided", HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}
		}
		else
		{
			return Response2.generateResponse("Wrong Answer is provided same as correct answer", HttpStatus.BAD_REQUEST, "400");
		}
	}
	@GetMapping(value="/getAllQuiz")
	public ResponseEntity<?> getAllQuiz()
	{
		List<QuizEntity> q=quizService.getAllQuiz();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",q);
		
	}
}
