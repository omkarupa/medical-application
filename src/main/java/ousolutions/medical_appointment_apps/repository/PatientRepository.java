package ousolutions.medical_appointment_apps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ousolutions.medical_appointment_apps.models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
