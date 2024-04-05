package com.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.education.entity.Notes;

public interface NotesRepo extends JpaRepository <Notes,Long> 
{
List<Notes> findByClassCode(String classCode);
}
