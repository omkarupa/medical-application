package ousolutions.medical_appointment_apps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ousolutions.medical_appointment_apps.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);
	

}
