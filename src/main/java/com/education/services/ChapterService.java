package com.education.services;

import org.springframework.stereotype.Service;

import com.education.entity.ChapterEntity;
import com.education.model.ChapterDTO;
@Service
public class ChapterService {

	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ChapterService.class);
	
	public String saveChapter(ChapterDTO chapterDTO)
	{
		try
		{
		ChapterEntity chapterEntity=new ChapterEntity();
		chapterEntity.setChapterName(chapterDTO.getChapterName());
		chapterEntity.setChapterCode(chapterDTO.getChapterCode());
		chapterEntity.setChapterDescription(chapterDTO.getChapterDescription());
		chapterEntity.setClassCode(chapterDTO.getClassCode());
		return "Success";
		} catch(Exception e)
		  {
			log.error("There is an error of saving the chapter : {}" ,e.getMessage());
			return "Error";
		  }
		
	}
}

