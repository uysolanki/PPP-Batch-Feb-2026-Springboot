package com.itp.amazon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyAppSecurity 
{

	 @Bean
	    public UserDetailsService userDetailsService() {

	        UserDetails admin = User.builder()
	                .username("jetha")
	                .password(passwordEncoder().encode("jetha123"))
	                .authorities("ADMIN")
	                .build();

	        UserDetails user = User.builder()
	                .username("bagha")
	                .password(passwordEncoder().encode("bagha123"))
	                .authorities("USER")
	                .build();

	        return new InMemoryUserDetailsManager(admin, user);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        
	        http.authorizeRequests()
	        .requestMatchers("/getAllStudentsFE","/saveStudentForm").hasAnyAuthority("USER","ADMIN")
	        .requestMatchers("/deleteStudentFE/**","/updateStudentForm/**").hasAuthority("ADMIN")
	        .anyRequest().authenticated()
	        .and()
	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAllStudentsFE").permitAll()
	        .and()
	        .logout().logoutSuccessUrl("/login").permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/403")
	        .and()
	        .cors().and().csrf().disable();
	        return http.build();
	    }
}
