package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.QuizEntity;

public interface QuizRepo extends JpaRepository <QuizEntity,Long> 
{

}
