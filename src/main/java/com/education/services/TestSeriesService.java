package com.education.services;

import java.util.Base64;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.education.entity.TestSeries;
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
			//testSeries.setClassCode(testSeriesDTO.getClassCode());
		
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
	public List<TestSeries> getAllTestSeries()
	{
		return testSeriesRepo.findAll();
	}
	public List<TestSeries> getTestSeriesByClassCode(String classCode)
	{
		return testSeriesRepo.findByClassCode(classCode);
	}
}
