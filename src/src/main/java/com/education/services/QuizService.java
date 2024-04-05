package com.education.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.Question;
import com.education.entity.QuizEntity;
import com.education.model.QuestionDTO;
import com.education.model.QuizDTO;
import com.education.repository.QuestionRepo;
import com.education.repository.QuizRepo;

@Service
public class QuizService {
	
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuizService.class);
	//@Autowired
	//private QuizRepo quizRepo;
	
	@Autowired
	ModelMapper mapper;

	@Autowired
	private QuizRepo quizRepo;
	@Autowired
	private  QuestionRepo questionRepo;
	
	public QuizDTO saveQuiz(QuizDTO quizDTO)
	{
		try
		{
		  QuizEntity qEntity=mapper.map(quizDTO, QuizEntity.class);
		  
		//QuizEntity q=new QuizEntity();
		//q.setTitle(quizDTO.getTitle());
		//q.setDescription(quizDTO.getDescription());
		//q.setNoOfQuestions(quizDTO.getNoOfQuestions());
		//q.setMaxMarks(quizDTO.getMaximumMarks()
		//q.setQuestion(quizDTO.ge);
		Set<Question> qs=new HashSet<>();
		if(quizDTO.getQuestionDTO()!=null)
		{
			for(QuestionDTO qDTO:quizDTO.getQuestionDTO())
			{
				Question question=mapper.map(qDTO, Question.class);
				Question savedQuestion=questionRepo.save(question);
				savedQuestion.setQuiz(qEntity);
				qs.add(savedQuestion);
			}
		}
		 qEntity.setQuestion(qs);
		 QuizEntity savedEntity=quizRepo.save(qEntity);
		QuizDTO savedDTO=mapper.map(savedEntity, QuizDTO.class);
		  if(savedDTO != null && savedEntity.getQuestion() != null) {
		        Set<QuestionDTO> savedQuestionDTOs = new HashSet<>();
		        for(Question savedQuestion : savedEntity.getQuestion()) {
		            savedQuestionDTOs.add(mapper.map(savedQuestion, QuestionDTO.class));
		        }
		        savedDTO.setQuestionDTO(savedQuestionDTOs);
		    }
		return savedDTO;
		} catch(Exception e)
		{
			e.printStackTrace();
			log.error("There is an error for quiz for questions : {}",e.getMessage());
			return null;
		}
		
	}
	public List<QuizEntity> getAllQuiz()
	{
		return quizRepo.findAll();
	}
	
	/*public Set<QuizEntity>  getQuestionofQuiz(Long quizId)
	{
		Optional<Question> qeOptional=quizRepo.findById(quizId);
             if(qeOptional.isPresent())
             {
            	 QuizEntity qe=qeOptional.get();
            	 return qe.getQuestion();
             }
             else
             {
            	 return null;
             }
	}*/
	public List<QuestionDTO> getQuestionsByQuiz(Long questionId)
	{
		List<Question> qt=questionRepo.findByQuestionId(questionId);
		List<QuestionDTO> s=new ArrayList<>();
		for(Question e:qt)
		{
			s.add(mapper.map(e, QuestionDTO.class));
		}
		return s;
	}
	public List<QuestionDTO> getAllQuestions()
	{
		List<Question> p=questionRepo.findAll();
		return p.stream().map(this:: convertToDTO).collect(Collectors.toList());
	}
	
	private QuestionDTO convertToDTO(Question question)
	{
		
		return mapper.map(question, QuestionDTO.class);
	}
	public List<QuestionDTO> getQuestionOfQuizByClassCode(String classCode)
	{
		List<Question> p=questionRepo.findQuestionByClassCode(classCode);
		return p.stream().map(this::convertToDTO).collect(Collectors.toList());
		
	}
	

}
