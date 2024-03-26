
package com.education.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.PreviousYearQuestions;
public interface PreviousYearQuestionsRepo extends JpaRepository <PreviousYearQuestions,Long> 
{
List<PreviousYearQuestions> findByType(String type);
}
