package com.education.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.entity.OtpEntity;
import com.education.entity.SignEntity;
import com.education.model.EmailDTO;
import com.education.model.ResetPasswordDTO;
import com.education.model.Response2;
import com.education.model.ResponseWithObject;
import com.education.model.VerifyEmailOtpDTO;
import com.education.repository.OtpRepo;
import com.education.repository.UserRepo;
import com.education.services.OtpService;
import com.education.services.PasswordService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@Tag(name = "Email-API")

public class EmailController {
      
	@Autowired
	private OtpService otpService;
	
	
	@Autowired
	PasswordService passwordService;	
	@PostMapping(value="/sendOtpByEmail")
	@Operation(summary="send otp through email",description="this api is send otp through email")
	public ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO)
	{
		
		EmailDTO response=otpService.emailByOtp(emailDTO);
		
		if(response!=null && response.getOtp()!=null)
		{
			return new ResponseWithObject().generateResponse("Email send successfully through otp",HttpStatus.OK,"200",response);
		}
		else
		{
			return new ResponseWithObject().generateResponse("Email is not send successfully through otp",HttpStatus.INTERNAL_SERVER_ERROR,"500","");
		}
	}
	@PostMapping(value="/verifyOtpByEmail")
	@Operation(summary="to verify otp by email",description="this api is basically to verify otp through email")
	public ResponseEntity<?> verifyOtp(@RequestBody VerifyEmailOtpDTO verifyEmailDTO)
	{
		String respose=otpService.verifyOtpByEmail(verifyEmailDTO);
				if("Success".equals(respose))				{
					return Response2.generateResponse("Email is verified through OTP",HttpStatus.OK,"200");
				}
				else
				{
					return Response2.generateResponse("Wrong email is verified through OTP", HttpStatus.INTERNAL_SERVER_ERROR, "500");
				}
	}
	 
		
		@PostMapping(value = "/resetPassword")
		@Operation(summary = "to reset the password", description = "this api is for reset the password")
		public ResponseEntity<?> resetToPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
			String e = passwordService.resetPassword(resetPasswordDTO);
			if ("Success".equals(e)) {
				return Response2.generateResponse("Password reset successfully", HttpStatus.OK, "200");
			} else {
				return Response2.generateResponse("Password cannot resend ", HttpStatus.BAD_REQUEST, "400");
			}

		}
}