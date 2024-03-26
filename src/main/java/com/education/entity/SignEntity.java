package com.education.entity;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SignEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	private String mobileNumber;
	private String name;
	private String email;
	private String password;
}
