package ousolutions.medical_appointment_apps.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ousolutions.medical_appointment_apps.dtos.PatientRegisterationDTO;
import ousolutions.medical_appointment_apps.models.Patient;
import ousolutions.medical_appointment_apps.models.User;
import ousolutions.medical_appointment_apps.repository.PatientRepository;
import ousolutions.medical_appointment_apps.repository.UserRepository;
import ousolutions.medical_appointment_apps.util.PatientMapper;
import ousolutions.medical_appointment_apps.util.UserMapper;

@Service
@RequiredArgsConstructor
public class UserRegisterationService {
	
	private final UserMapper mapper;
	
	private final UserRepository userRepo;
	
	private final PatientRepository patientRepo;
	
	public User registerUser(PatientRegisterationDTO registerDTO)
	{
		User user = mapper.mapUserFromRegisterationDto(registerDTO);
		
		return userRepo.save(user);
	}
	
	public Patient registerPatient(PatientRegisterationDTO registerDTO)
	{
		User user = registerUser(registerDTO);
		if(user != null)
		{
			Patient patient = PatientMapper.getInstance().mapPatientFromRegisterationDto(registerDTO,user.getId().toString());
			
			return patientRepo.save(patient);
		}
		
		return null;
	}

}
