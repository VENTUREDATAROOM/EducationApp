package com.education.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.QuizEntity;
import com.education.model.QuizDTO;
import com.education.repository.QuizRepo;

@Service
public class QuizService {
	
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuizService.class);
	@Autowired
	private QuizRepo quizRepo;
	
	@Autowired
	ModelMapper mapper;
	public String saveQuiz(QuizDTO quizDTO)
	{
		try
		{
		  QuizEntity qe=mapper.map(quizDTO,QuizEntity.class);
		  qe.setQuestionText(quizDTO.getQuestionText());
		  qe.setOption1(quizDTO.getOption1());
		  qe.setOption2(quizDTO.getOption2());
		  qe.setOption3(quizDTO.getOption3());
		  qe.setOption4(quizDTO.getOption4());
		  qe.setCorrectAnswer(quizDTO.getCorrectAnswer());
		  qe.setWrongAnswer(quizDTO.getWrongAnswer());
		  qe.setCategory(quizDTO.getCategory());
		  quizRepo.save(qe);
		  return "Success";
		  
		} catch(Exception e)
		{
			log.error("There is an error in quiz app : {}",e.getMessage());
			return "Error";
		}
	}
	public List<QuizEntity> getAllQuiz()
	{
		return quizRepo.findAll();
	}

}
