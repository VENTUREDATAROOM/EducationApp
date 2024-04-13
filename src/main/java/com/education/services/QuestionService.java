package com.education.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.repository.QuestionRepo;
import com.education.entity.QuestionEntity;
import com.education.model.QuestionDTO;
@Service
public class QuestionService {

	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuestionService.class);
	@Autowired
	private QuestionRepo questionRepo;
	public List<QuestionEntity> getAllQuestions()
	{
		return questionRepo.findAll();
	}
	
	
	public List<QuestionEntity> getQuestionByCategory(String category)
	{
		return questionRepo.findByCategory(category);
	}
	
	public String saveQuestion(QuestionDTO questionDTO)
	{
		try
		{
		QuestionEntity questionEntity=new QuestionEntity();
	    questionEntity.setQuestionTitle(questionDTO.getQuestionTitle());
	    questionEntity.setOption1(questionDTO.getOption1());
        questionEntity.setOption2(questionDTO.getOption2());	
        questionEntity.setOption3(questionDTO.getOption3());
        questionEntity.setOption4(questionDTO.getOption4());
        questionEntity.setRightAnswer(questionDTO.getRightAnswer());
        questionEntity.setDifficultyLevel(questionDTO.getDifficultyLevel());
        questionEntity.setCategory(questionDTO.getCategory());
        return "Success";
		} catch(Exception e)
		 {
		 log.error("There is an error for questions : {}",e.getMessage());
		 return "Error";
		 }
	   } 
	
	
	
}

