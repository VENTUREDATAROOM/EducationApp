//package com.education.services;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.education.entity.Question;
//import com.education.entity.QuizEntity;
//import com.education.model.QuestionDTO;
//import com.education.repository.QuestionRepo;
//import com.education.repository.QuizRepo;
//
//
//@Service
//public class QuestionService {
//
//	
//	
//	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuestionService.class);
//	@Autowired
//	private QuestionRepo questionRepo;
//	
//	@Autowired 
//	private QuizRepo quizRepo;
//	
//	public QuestionDTO saveQuestion(QuestionDTO questionDTO)
//	{
//		try
//		{
//		Question qe=new Question();
//		qe.setContent(questionDTO.getContent());
//		qe.setOption1(questionDTO.getOption1());
//		qe.setOption2(questionDTO.getOption2());
//		qe.setOption3(questionDTO.getOption3());
//		qe.setOption4(questionDTO.getOption4());
//		qe.setAnswer(questionDTO.getAnswer());
//		return questionDTO;
//		} catch(Exception e)
//		{
//			log.error("There is an error for quiz app : {}",e.getMessage());
//			return null;
//		}
//	}
//		public List<Question> getAllQuestion()
//		{
//			return questionRepo.findAll();
//		}
//		
//		/*public List<Question> getQuestionByQuiz(Long quizId)
//		{
//			Optional<QuizEntity> qeOptional=quizRepo.findById(quizId);
//			return qeOptional.map()
//		}*/
//		public Set<Question>  getQuestionofQuiz(Long quizId)
//		{
//			Optional<QuizEntity> qeOptional=quizRepo.findById(quizId);
//	             if(qeOptional.isPresent())
//	             {
//	            	 QuizEntity qe=qeOptional.get();
//	            	 return qe.getQuestion();
//	             }
//	             else
//	             {
//	            	 return null;
//	             }
//		}
//		/*public List<Question> getQuestionByQuizId(Long questionId)
//		
//			return questionRepo.findByQuizId(questionId);
//		}*/
//		
//		
//}
