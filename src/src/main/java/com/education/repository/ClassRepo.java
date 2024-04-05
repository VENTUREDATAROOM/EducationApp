package com.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.ClassEntity;

public interface ClassRepo extends JpaRepository <ClassEntity,Long> 
{

}
