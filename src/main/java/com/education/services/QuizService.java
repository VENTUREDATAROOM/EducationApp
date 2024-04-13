package com.education.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.QuestionEntity;
import com.education.entity.QuizEntity;
import com.education.model.QuestionDTO;
import com.education.model.QuizDTO;
import com.education.model.Response;
import com.education.repository.QuestionRepo;
import com.education.repository.QuizRepo;
@Service
public class QuizService {

	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(QuizService.class);
	@Autowired
	private QuestionRepo questionRepo;
	@Autowired
     private QuizRepo quizRepo;
	 public String createQuiz(QuizDTO quizDTO) {

		 try
		 {
	        //List<QuestionEntity> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);
              List<QuestionEntity> questions=questionRepo.findAll();
	        QuizEntity quiz = new QuizEntity();
	        quiz.setTitle(quizDTO.getTitle());
	       // quiz.setClassCode(quizDTO.getClassCode());
	        quiz.setCategory(quizDTO.getCategory());
	        quiz.setNumQ(quizDTO.getNumQ());
	        quiz.setQ(questions);
	        quiz.setClassCode(quizDTO.getClassCode());
	        //quiz.setQuestions(questions);
	        quizRepo.save(quiz);
	        return "Success";
		 } catch(Exception e)
		 {
			 log.error("There is an error for creating a quiz : {} ",e.getMessage());
			 return "Error";
		 }
		 }

	    public List<QuestionDTO> getQuizQuestions(Long quizId) {
	        Optional<QuizEntity> quiz = quizRepo.findById(quizId);
	        List<QuestionEntity> questionsFromDB = quiz.get().getQ();
	        List<QuestionDTO> questionsForUser = new ArrayList<>();
	        for(QuestionEntity q : questionsFromDB){
	            QuestionDTO qw = new QuestionDTO();
	            qw.setQuestionTitle(q.getQuestionTitle());
	            qw.setOption1(q.getOption1());
	            qw.setOption2(q.getOption2());
	            qw.setOption3(q.getOption3());
	            qw.setOption4(q.getOption4());
	            qw.setRightAnswer(q.getRightAnswer());
	            qw.setWrongAnswer(q.getWrongAnswer());
	            qw.setCategory(q.getCategory());
	            questionsForUser.add(qw);
	        }

	        return questionsForUser;

	    }
	    public List<QuizEntity> getQuizzesByClassCode(String classCode)
	    {
	    	List<QuizEntity> qe=quizRepo.findByClassCode(classCode);
	    	return qe;
	    }

	   /* public Integer calculateResult(Long quizid, List<Response> responses) {
	        QuizEntity quiz = quizRepo.findById(quizid).get();
	        List<QuestionEntity> questions = quiz.getQ();
	        int right = 0;
	        int i = 0;
	        for(Response r : responses){
	            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
	                right++;

	            i++;
	        }
	        return right;
	    }*/
	}

