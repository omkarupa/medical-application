package ousolutions.medical_appointment_apps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ousolutions.medical_appointment_apps.dtos.PatientRegisterationDTO;
import ousolutions.medical_appointment_apps.service.UserRegisterationService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/register/v1")
public class PatientRegisterController {
	
	private final UserRegisterationService userService;
	
	
	
	@PostMapping("/patient")
	public ResponseEntity<String> registerPatient(@RequestBody PatientRegisterationDTO patientRegDTO)
	{
		log.info("patient >>>" + patientRegDTO);
		
		if(userService.registerPatient(patientRegDTO) == null) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>("User Registerd Succesffuly : " + patientRegDTO.getFullName(), HttpStatus.OK);
	}

}
