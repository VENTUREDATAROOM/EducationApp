package com.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import com.education.entity.TestSeries;
import com.education.model.Response2;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.model.TestSeriesDTO;
import com.education.services.TestSeriesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api")
@Tag(name="TestSeries-API")
public class TestSeriesController {

	@Autowired
	TestSeriesService testSeriesService;
	@PostMapping(value="/addTestSeries",consumes= {MediaType.MULTIPART_FORM_DATA_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary="to add test series",description="this api is used to add test series for class")
	public ResponseEntity<?> addTestSeries(@ModelAttribute TestSeriesDTO testSeriesDTO)
	{
		
	
		TestSeriesDTO savedDTO=testSeriesService.saveTestSeries(testSeriesDTO);
		if(savedDTO!=null)
		{
			return  new ResponseWithObject().generateResponse("Test Series details are saved", HttpStatus.OK, "200",savedDTO);
			
		}
		
		else
		{
			return  new ResponseWithObject().generateResponse("Test series have some error",HttpStatus.INTERNAL_SERVER_ERROR,"500","");
		}
	}
	@GetMapping(value="/findTestSeries")
	@Operation(summary="to find the Test Series",description="this api is list of test series")
	public ResponseEntity<?> getAllTestSeries()
	{
		List<TestSeriesDTO> t=testSeriesService.getAllTestSeries();
		return new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",t);
	}
	@GetMapping(value="/findTestSeriesByClassCode")
	@Operation(summary="to find test series by class code",description="this api is list of test series will appear using classcode")
	public ResponseEntity<?> getTestSeriesByClass(@RequestParam ("classcode") String classCode)
	{
		List<TestSeriesDTO> res=testSeriesService.getTestSeriesByClassCode(classCode);
		return new ResponseWithList().generateResponse("provide", HttpStatus.OK, "200", res);
	}
	
}

