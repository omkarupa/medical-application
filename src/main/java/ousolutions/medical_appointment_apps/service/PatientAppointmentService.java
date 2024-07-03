package ousolutions.medical_appointment_apps.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ousolutions.medical_appointment_apps.models.AppointmentDetails;
import ousolutions.medical_appointment_apps.repository.AppointmentDetailsRepository;
import ousolutions.medical_appointment_apps.util.DateUtil;

@Service
@RequiredArgsConstructor
public class PatientAppointmentService {
	
	private final AppointmentDetailsRepository appointmentRepository;
	
	
	public AppointmentDetails createAppointment(String patientId)
	{
		
		AppointmentDetails appointmentDetails 
			= AppointmentDetails.builder()
			.appointmentAppliedDate(DateUtil.getInstance().getCurrentDate())
			.appointmentAllotedDate(DateUtil.getInstance().getCurrentDate())
			.build();
		
		return appointmentRepository.save(appointmentDetails);
	}
	
	

}
