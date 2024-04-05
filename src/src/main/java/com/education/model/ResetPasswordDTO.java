package com.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResetPasswordDTO {

	
	private String email;
	private String newPassword;
	private String confirmPassword;
	
}
