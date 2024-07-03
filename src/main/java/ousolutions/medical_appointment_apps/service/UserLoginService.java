package ousolutions.medical_appointment_apps.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ousolutions.medical_appointment_apps.models.User;
import ousolutions.medical_appointment_apps.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {
	
	private final UserRepository userRepo;
	
	private final PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepo.findByUsername(username);
		
		if(!user.isPresent())
		{
			 throw new UsernameNotFoundException("User does not exists with username" + username);
		}
		
		
		var objUser = user.get();
		
		 UserDetails userDetails  = org.springframework.security.core.userdetails.User
				 .builder() 
				 .username(objUser.getUsername()) 
				 .password(objUser.getPassword())
				 .roles(getRoles(objUser.getRoles()))
				 .build();
		
		return userDetails;
	}
	
	public String [] getRoles(String roles)
	{
		if(!roles.isEmpty() && null != roles)
		{
			return roles.split(",");
		}
		
		return null;
	}

}
