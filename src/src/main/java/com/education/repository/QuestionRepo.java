package com.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.education.entity.Question;
public interface QuestionRepo extends JpaRepository <Question,Long> 
{

	List<Question> findByQuestionId(Long questionId);
	List<Question> findQuestionByClassCode(String classCode);
}
