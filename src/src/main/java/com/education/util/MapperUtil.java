package com.education.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

	/*~~(Unable to determine parameter type)~~>*/@Autowired
	ModelMapper modelMapper;

	public MapperUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {

		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}

}

