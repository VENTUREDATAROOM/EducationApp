package com.education.services;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.entity.ClassEntity;
import com.education.model.ClassDTO;
import com.education.repository.ClassRepo;
@Service
public class ClassService {

	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	ClassRepo classRepo;
	
	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ClassService.class);
	
	public ClassDTO saveClass(ClassDTO classDTO)
	{
		try
		{
		ClassEntity ce=mapper.map(classDTO, ClassEntity.class);
		ce.setClassname(classDTO.getClassName());
		ce.setClassdescription(classDTO.getClassDescription());
		String classCode=generateUniqueClassCode();
		ce.setClassCode(classCode);
		classDTO.setClassCode(classCode);
		
		 return classDTO;
		}catch(Exception e)
		{
			log.error("There is error in classes : {}",e.getMessage());
			return classDTO;
		}
		
	   	
	}
	public List<ClassEntity> getAllClasses()
	{
		return  classRepo.findAll();
	}
	public String generateUniqueClassCode()
	{
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}

}
