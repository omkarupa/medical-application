package ousolutions.medical_appointment_apps.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("api/patients/v1")
public class PatientController {
	
	
	@GetMapping("/message")
	public ResponseEntity<String> getMessage()
	{
		return new ResponseEntity<String>( "Welcome to Medical Appointment Application",HttpStatus.OK);
	}
	
	

}
