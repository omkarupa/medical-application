package ousolutions.medical_appointment_apps.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import ousolutions.medical_appointment_apps.dtos.PatientRegisterationDTO;
import ousolutions.medical_appointment_apps.models.User;

@RequiredArgsConstructor
@Component
public class UserMapper {
	
	private final PasswordEncoder encoder;
	
	public User mapUserFromRegisterationDto(PatientRegisterationDTO patientRegDTO)
	{
		User user = User.builder()
				.username(patientRegDTO.getUsername())
				.password(encoder.encode(patientRegDTO.getPassword()))
				.roles(patientRegDTO.getRoles())
				.userRegisterationDt(DateUtil.getInstance().getCurrentDate())
				.build();
		return user;
	}

}
