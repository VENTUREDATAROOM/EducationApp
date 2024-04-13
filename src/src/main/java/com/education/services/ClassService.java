package com.education.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
		ClassEntity ce=new ClassEntity();
		ce.setClassName(classDTO.getClassName());
		ce.setClassDescription(classDTO.getClassDescription());
		String classCode=generateUniqueClassCode();
		ce.setClassCode(classCode);
		classDTO.setClassCode(classCode);
		classRepo.save(ce);
		 return classDTO;
		}catch(Exception e)
		{
			log.error("There is error in classes : {}",e.getMessage());
			return null;
		}
		
	   	
	}
	public List<ClassDTO> getAllClasses()
	{
		List<ClassEntity> c=classRepo.findAll();
		return c.stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	public ClassDTO convertToDTO(ClassEntity ce)
	{
		return mapper.map(ce, ClassDTO.class);
	}
	public String generateUniqueClassCode()
	{
		return UUID.randomUUID().toString().replace("-","").substring(12);
		
	}

}
