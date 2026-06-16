package com.itp.amazon.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itp.amazon.entity.DBUser;
import com.itp.amazon.repository.DBUserRepository;

@Service
public class DBUserService {

	@Autowired
	DBUserRepository dbUserRepository;

	public void saveUser(DBUser user) {

		user.setPassword(passwordEncoder().encode(user.getPassword()));
		user.setAccountEnabledStatus(1);
		user.setAccountExpiryDate(LocalDate.now().plusMonths(12));
		user.setAccountLockedStatus(1);
		user.setCredExpiryDate(LocalDate.now().plusMonths(4));
		dbUserRepository.save(user);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
