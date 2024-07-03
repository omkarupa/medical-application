package ousolutions.medical_appointment_apps.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		
		
		http.authorizeHttpRequests(registry -> {
			
			registry
			.requestMatchers("api/register/**").permitAll()
			.requestMatchers("api/patients/v1/**").hasRole("USER")
			.requestMatchers("api/admin/v1/**").hasRole("ADMIN")
			.anyRequest().authenticated();
		});
		
		http.formLogin(AbstractAuthenticationFilterConfigurer::permitAll);
		http.httpBasic();
		
		http.cors( cors -> cors.disable());
		http.csrf( csrf -> csrf.disable());
	
		return http.build();
		
	}
	
	/*
	 * @Bean public UserDetailsService userDetailsService() { UserDetails normalUser
	 * = User.builder() .username("gc") .password(encoder().encode("1234"))
	 * .roles("USER") .build();
	 * 
	 * UserDetails adminUser = User.builder() .username("admin")
	 * .password(encoder().encode("1234")) .roles("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(normalUser,adminUser); }
	 */
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	

}
