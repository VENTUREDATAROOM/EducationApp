package com.education.services;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.education.entity.Notes;
import com.education.entity.TestSeries;
import com.education.model.NotesDTO;
import com.education.model.TestSeriesDTO;
import com.education.repository.TestSeriesRepo;
@Service
public class TestSeriesService {

	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TestSeriesService.class);
	@Autowired
	TestSeriesRepo testSeriesRepo;
	@Autowired
	ModelMapper mapper;
	public TestSeriesDTO saveTestSeries(TestSeriesDTO testSeriesDTO)
	{
		
		try
		{
			TestSeries testSeries=new TestSeries();
			testSeries.setTestSeriesName(testSeriesDTO.getTestSeriesName());
			//String classCode=generateUniqueClassCode();
			testSeries.setClassCode(testSeriesDTO.getClassCode());
		
			byte[] fileBytes=Base64.getEncoder().encode(testSeriesDTO.getTestSeriesFile().getBytes());
			String baseTestSeries=Base64.getEncoder().encodeToString(testSeriesDTO.getTestSeriesFile().getBytes());
			testSeries.setTestPdf(fileBytes);
			  testSeriesRepo.save(testSeries);
			  
			  testSeriesDTO.setBaseTestSeries(baseTestSeries);
			  testSeriesDTO.setTestSeriesFile(null);
			  
			 return testSeriesDTO;
		} catch(Exception e)
		{
			log.error("There is an exception for test series {} ",e.getMessage());
			return testSeriesDTO;
		}
	}
	public List<TestSeriesDTO> getAllTestSeries()
	{
		List<TestSeries> testSeriesList=testSeriesRepo.findAll();
		return testSeriesList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	public List<TestSeriesDTO> getTestSeriesByClassCode(String classCode)
	{
		List<TestSeries> testSeriesList=testSeriesRepo.findByClassCode(classCode);
		return testSeriesList.stream().map(this::convertToDTO).collect(Collectors.toList());
		
	}
	private TestSeriesDTO  convertToDTO(TestSeries testSeries)
	{
		TestSeriesDTO testSeriesDTO=new TestSeriesDTO();
		testSeriesDTO.setTestSeriesId(testSeries.getTestSeriesId());
		
		testSeriesDTO.setTestSeriesName(testSeries.getTestSeriesName());
		testSeriesDTO.setClassCode(testSeries.getClassCode());
		
		byte[] decodedPdf = Base64.getDecoder().decode(testSeries.getTestPdf());
		String baseTestPdf=new String(decodedPdf,StandardCharsets.UTF_8);
		testSeriesDTO.setBaseTestSeries(baseTestPdf);
		return testSeriesDTO;
	}


}
