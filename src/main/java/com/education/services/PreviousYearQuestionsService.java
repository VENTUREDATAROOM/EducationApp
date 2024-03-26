package com.education.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.PreviousYearQuestions;
import com.education.model.PreviousYearQuestionsDTO;
//import com.education.model.QuestionPaperMainDTO;
import com.education.repository.PreviousYearQuestionsRepo;

@Service
public class PreviousYearQuestionsService {
	
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PreviousYearQuestionsService.class);
	@Autowired
	private PreviousYearQuestionsRepo previousYearQuestionsRepo;
	public PreviousYearQuestionsDTO saveQuestionPaper(PreviousYearQuestionsDTO previousYearQuestionsDTO)
	{
		try
		{
		PreviousYearQuestions previousYearQuestions=new PreviousYearQuestions();
		previousYearQuestions.setName(previousYearQuestionsDTO.getName());
		previousYearQuestions.setType(previousYearQuestionsDTO.getType());
		previousYearQuestionsRepo.save(previousYearQuestions);
		return previousYearQuestionsDTO;
		} catch(Exception e)
		{
			log.error("There is missing in previous year question paper : {}" ,e.getMessage());
			return null;
		}
		
		
	}
	public List<PreviousYearQuestions> getAllQuestionPaper(String type)
	{
		return previousYearQuestionsRepo.findByType(type);
	}
	

}
