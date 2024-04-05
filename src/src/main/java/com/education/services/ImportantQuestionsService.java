package com.education.services;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.ImportantQuestionEntity;
import com.education.model.ImportantQuestionDTO;
import com.education.repository.ImportantQuestionRepo;

@Service
public class ImportantQuestionsService {

	
	  private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ImportantQuestionsService.class);
	    @Autowired
		private ImportantQuestionRepo importantQuestionRepo;
	    @Autowired
	    private ModelMapper mapper;
	
	public ImportantQuestionDTO saveImportantQuestion(ImportantQuestionDTO importantQuestionDTO)
	{
		
		try
		{
		ImportantQuestionEntity importantQuestion=new ImportantQuestionEntity();
		importantQuestion.setClassCode(importantQuestionDTO.getClassCode());
		byte[] questionBytes=Base64.getEncoder().encode(importantQuestionDTO.getImportantQuestionPdf().getBytes());
		importantQuestion.setQuestionPdf(questionBytes);
		importantQuestionRepo.save(importantQuestion);
		String baseQuestion=Base64.getEncoder().encodeToString(importantQuestionDTO.getImportantQuestionPdf().getBytes());
		importantQuestionDTO.setBaseImportantQuestionPdf(baseQuestion);
		importantQuestionDTO.setImportantQuestionPdf(null);
		//importantQuestionRepo.save(importantQuestion);
		return importantQuestionDTO;
		} catch(Exception e)
		 { 
		   e.printStackTrace();
		  log.error("There is an error for important questions : {} ",e.getMessage());
		  return null;
		 }
		
	}
	public List<ImportantQuestionDTO> getAllImportantQuestion()
	{
		List<ImportantQuestionEntity> im=importantQuestionRepo.findAll();
		return im.stream().map(this::convertToDTO).collect(Collectors.toList());
		
	}
	public ImportantQuestionDTO convertToDTO(ImportantQuestionEntity  importantQuestion)
	{
		ImportantQuestionDTO importantQuestionDTO=new ImportantQuestionDTO();
		importantQuestionDTO.setImportantQuestionsId(importantQuestion.getImportantQuestionId());
		importantQuestionDTO.setImportantQuestionsId(importantQuestion.getImportantQuestionId());
		importantQuestionDTO.setClassCode(importantQuestion.getClassCode());
	     byte[] decodedPdf=Base64.getDecoder().decode(importantQuestion.getQuestionPdf());
	     String baseQuestionPdf=new String(decodedPdf,StandardCharsets.UTF_8);
	     importantQuestionDTO.setBaseImportantQuestionPdf(baseQuestionPdf);
	     return importantQuestionDTO;
		//importantQuestionDTO.setImportantQuestionPdf(importantQuestion.getQuestionPdf());
	}
	
}


