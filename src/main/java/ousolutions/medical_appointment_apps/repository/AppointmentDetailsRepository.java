package ousolutions.medical_appointment_apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ousolutions.medical_appointment_apps.models.AppointmentDetails;

public interface AppointmentDetailsRepository extends JpaRepository<AppointmentDetails, Long> {

}
