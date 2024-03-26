package com.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.entity.ClassEntity;
import com.education.model.ClassDTO;
import com.education.model.ResponseWithList;
import com.education.model.ResponseWithObject;
import com.education.services.ClassService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api")
@Tag(name = "Class-API")
public class ClassesController {
	
	
	@Autowired
	ClassService classService;
	
	
	@PostMapping(value="/addClass")
	public ResponseEntity<?> addClass(@RequestBody ClassDTO classDTO)
	{
		ClassDTO c=classService.saveClass(classDTO);
		return new ResponseWithObject().generateResponse("class are saved", HttpStatus.OK, "200", c);
	}

	
	@GetMapping(value="/findAllClasses")
	public ResponseEntity<?> getAllClass()
	{
		
		List<ClassEntity> classes=classService.getAllClasses();
		return  new ResponseWithList().generateResponse("provide",HttpStatus.OK,"200",classes);
	}
}
