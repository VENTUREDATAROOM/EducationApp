package com.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassDTO {

	
	private Long classId;
	private String className;
	private String classDescription;
	private String classCode;
	
}
