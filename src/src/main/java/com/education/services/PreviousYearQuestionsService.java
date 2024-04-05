package com.education.services;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.PreviousYearQuestions;
import com.education.model.PreviousYearQuestionsDTO;
//import com.education.model.QuestionPaperMainDTO;
import com.education.repository.PreviousYearQuestionsRepo;

@Service
public class PreviousYearQuestionsService {
	
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PreviousYearQuestionsService.class);
	@Autowired
	private PreviousYearQuestionsRepo previousYearQuestionsRepo;
	public PreviousYearQuestionsDTO saveQuestionPaper(PreviousYearQuestionsDTO previousYearQuestionsDTO)
	{
		try
		{
		PreviousYearQuestions previousYearQuestions=new PreviousYearQuestions();
		previousYearQuestions.setMasterCode(previousYearQuestionsDTO.getMasterCode());
		previousYearQuestions.setYear(previousYearQuestionsDTO.getYear());
		byte[] pdfBytes=Base64.getEncoder().encode(previousYearQuestionsDTO.getPdfFile().getBytes());
		String basePreviousPdfFile=Base64.getEncoder().encodeToString(previousYearQuestionsDTO.getPdfFile().getBytes());
		previousYearQuestions.setPdf(pdfBytes);
		previousYearQuestionsDTO.setPdfFile(null);
		previousYearQuestionsDTO.setBasePreviousPdfFile(basePreviousPdfFile);
		
		//previousYearQuestions.setName(previousYearQuestionsDTO.getName());
		//;previousYearQuestions.setType(previousYearQuestionsDTO.getType());
		previousYearQuestionsRepo.save(previousYearQuestions);
		return previousYearQuestionsDTO;
		} catch(Exception e)
		{
			log.error("There is missing in previous year question paper : {}" ,e.getMessage());
			return null;
		}
		
		
	}
	/*public List<PreviousYearQuestions> getAllQuestionPaper(String type)
	{
		return previousYearQuestionsRepo.findByType(type);
	}*/
	public List<PreviousYearQuestionsDTO> getQuestion()
	{
		List<PreviousYearQuestions> preList=previousYearQuestionsRepo.findAll();
		return preList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	/*public List<PreviousYearQuestionsDTO> getQuestions();
	{
		List<PreviousYearQuestions> preList=previousYearQuestionsRepo.findAll();
		
	}*/
	private PreviousYearQuestionsDTO convertToDTO(PreviousYearQuestions previousYearQuestions)
	{
		PreviousYearQuestionsDTO previousYearQuestionsDTO=new PreviousYearQuestionsDTO();
		previousYearQuestionsDTO.setMasterCode(previousYearQuestions.getMasterCode());
		previousYearQuestionsDTO.setYear(previousYearQuestions.getYear());
		previousYearQuestionsDTO.setId(previousYearQuestions.getId());
		byte[] decodedPdfFile=Base64.getDecoder().decode(previousYearQuestions.getPdf());
		String basePdfFile=new String(decodedPdfFile,StandardCharsets.UTF_8);
		previousYearQuestionsDTO.setBasePreviousPdfFile(basePdfFile);
		return previousYearQuestionsDTO;
	}
	
	public List<PreviousYearQuestionsDTO> getQuestionByMasterCode(String masterCode)
	{
		List<PreviousYearQuestions> preList=previousYearQuestionsRepo.findByMasterCode(masterCode);
		return preList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
}


