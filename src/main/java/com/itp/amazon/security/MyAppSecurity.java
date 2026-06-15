//package com.itp.amazon.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class MyAppSecurity 
//{
//	 //Authentication
//	  @Bean
//	    public UserDetailsService userDetailsService() {
//
//	        UserDetails admin1 = User.builder()
//	                .username("jetha")		//1. userdetails
//	                .password(passwordEncoder().encode("jetha123")) //2. password
//	                .authorities("ADMIN")   //3. authority
//	                .build();
//	        
//	        UserDetails admin2 = User.builder()
//	                .username("nitin")
//	                .password(passwordEncoder().encode("nitin123"))
//	                .authorities("ADMIN")
//	                .build();
//
//	        UserDetails user1 = User.builder()
//	                .username("bagha")
//	                .password(passwordEncoder().encode("bagha123"))
//	                .authorities("USER")
//	                .build();
//	        
//	        UserDetails user2 = User.builder()
//	                .username("magan")
//	                .password(passwordEncoder().encode("magan123"))  //encoding  Bcrypt
//	                .authorities("USER")   //LIST OF ROLES = AUTHOROTIES
//	                .build();
//
//	        return new InMemoryUserDetailsManager(admin1, admin2,user1,user2);
//	    }
//
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	    
//	    //Authorisation
//	    @Bean  
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        
//	        http.authorizeRequests()
//	        .requestMatchers("/getAllStudentsFE","/saveStudentForm").hasAnyAuthority("USER","ADMIN")
//	        .requestMatchers("/deleteStudentFE/**","/updateStudentForm/**").hasAuthority("ADMIN")
//	        .anyRequest().authenticated()
//	        .and()
//	        .formLogin().loginProcessingUrl("/login").successForwardUrl("/getAllStudentsFE").permitAll()
//	        .and()
//	        .logout().logoutSuccessUrl("/login").permitAll()
//	        .and()
//	        .exceptionHandling().accessDeniedPage("/403")
//	        .and()
//	        .cors().and().csrf().disable();
//	        return http.build();
//	    }
//}
