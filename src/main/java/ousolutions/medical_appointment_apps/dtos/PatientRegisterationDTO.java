package ousolutions.medical_appointment_apps.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRegisterationDTO {
	
	private String fullName;
	private String gender;
	private Date birthDate;
	private String mobileNumber;
	private String username;
	private String password;
	private String roles;
	

}
