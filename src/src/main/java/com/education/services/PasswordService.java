package com.education.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.education.entity.SignEntity;
import com.education.model.ResetPasswordDTO;
import com.education.repository.UserRepo;
@Service
public class PasswordService {

	private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PasswordService.class);

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	PasswordEncoder bcryptEncoder;
	public String resetPassword(ResetPasswordDTO resetPasswordDTO) {
		try {

			if (!resetPasswordDTO.getNewPassword().matches(resetPasswordDTO.getConfirmPassword())) {
				return "password did not match";
			}
			Optional<SignEntity> pOptional = userRepo.findByEmail(resetPasswordDTO.getEmail());
			if (!pOptional.isPresent()) 
			{
				return "User was not Found";
			} else {
				SignEntity s=pOptional.get();
				String newHashPassword = bcryptEncoder.encode(resetPasswordDTO.getNewPassword());
				s.setPassword(newHashPassword);
				userRepo.save(s);
				log.info("Password reset successfully for user : {}", resetPasswordDTO.getEmail());
				return "Success";
			}
		} catch (Exception e) {
			log.error("Error resetting password: {}", e.getMessage());
			return "Error";
		}

	}
}


