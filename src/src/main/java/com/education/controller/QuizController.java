package com.education.controller;

import java.util.List;
import java.util.Set;
import com.education.model.QuestionDTO;

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

import com.education.entity.Question;
import com.education.entity.QuizEntity;
import com.education.model.QuizDTO;
import com.education.model.Response2;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
//import com.education.services.QuestionService;
import com.education.services.QuizService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="Quiz-API")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//@Autowired
	//private QuestionService questionService;
	
	
	@PostMapping(value="/addQuiz")
	public ResponseEntity<?> addQuiz(@RequestBody QuizDTO quizDTO)
	{
		
		
		QuizDTO response=quizService.saveQuiz(quizDTO);
		if(response!=null)
		{
			return  new ResponseWithObject().generateResponse("Quiz details are saved", HttpStatus.OK, "200",response);
		}
		
		else
		{
			return Response2.generateResponse("Quiz details are not provided", HttpStatus.INTERNAL_SERVER_ERROR, "500");
		}
		
		
		
	}
	@GetMapping(value="/getAllQuiz")
	public ResponseEntity<?> getAllQuiz()
	{
		List<QuizEntity> q=quizService.getAllQuiz();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",q);
		
		
		
	}
	
	
	/*@GetMapping(value="/getQuestions/{quizId}")
	public ResponseEntity<Object> getQuestionByQuiz(@PathVariable Long quizId)
	{
		Set<Question> t=questionService.getQuestionofQuiz(quizId);
		if(t!=null && !t.isEmpty())
		{
			return new ResponseWithObject().generateResponse("provide", HttpStatus.OK,"200",t);
		}
		else
		{
			return new ResponseWithObject().generateResponse("not provide", HttpStatus.BAD_REQUEST, "400", "");
		}
	}*/
	
	/*@GetMapping(value="/getAllQuestionsByQuizId{questionId}")
	public ResponseEntity<?> getAllQuestionsByQuizId(@PathVariable Long quizId)
	{
		if(!quizRepo.existsById(quizId))
		{
			return new 
		}
	}*/
	
	@GetMapping(value="/getAllQestionsByQuiz/{questionId}")
     public ResponseEntity<?>  getAllQuestionByQuiz(@PathVariable Long questionId)
     {
		List<QuestionDTO> l=quizService.getQuestionsByQuiz(questionId);
		return new ResponseWithList().generateResponse("All Questions get displayed", HttpStatus.OK, "200", l);
     }

	 @GetMapping(value="/getQuestions")
	    public ResponseEntity<?> getAllQuestions() {
		 
	        List<QuestionDTO> questions = quizService.getAllQuestions();
	          
	        return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "200", questions);
	    }
	 
	 @GetMapping(value="/getQuestionByClassCode/{classCode}")
	 public ResponseEntity<?> getQuestionsByClassCode(@PathVariable String classCode)
	 {
		 List<QuestionDTO> qu=quizService.getQuestionOfQuizByClassCode(classCode);
		 return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "200", qu);
	 }
	
}
