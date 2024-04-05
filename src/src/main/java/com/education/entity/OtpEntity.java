package com.education.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class OtpEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String email;
	private String otp;
	private String otpSend;
	private String otpExpiry;
	
	
}
