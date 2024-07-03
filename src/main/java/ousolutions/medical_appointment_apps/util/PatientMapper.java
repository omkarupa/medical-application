package ousolutions.medical_appointment_apps.util;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ousolutions.medical_appointment_apps.dtos.PatientRegisterationDTO;
import ousolutions.medical_appointment_apps.models.Patient;
import ousolutions.medical_appointment_apps.models.User;

public class PatientMapper {
	
	private final static PatientMapper mapper = null;

	private PatientMapper() {}
	
	public static PatientMapper getInstance()
	{
		if(mapper == null)
		{
			return new PatientMapper();
		}
		
		return mapper;
	}
	

	
	
	public Patient mapPatientFromRegisterationDto(PatientRegisterationDTO patientRegDTO,String userId)
	{
		Patient patient = Patient.builder()
				.fullName(patientRegDTO.getFullName())
				.gender(patientRegDTO.getGender())
				.birthDate(patientRegDTO.getBirthDate())
				.mobileNumber(patientRegDTO.getMobileNumber())
				.userId(userId)
				.build();
		return patient;
	}
	

}
