package com.itp.amazon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itp.amazon.entity.DBUser;
import com.itp.amazon.repository.DBUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	DBUserRepository dbUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DBUser dbuser=dbUserRepository.findByUsername(username);
		
		if(dbuser==null)
			throw new UsernameNotFoundException("User does not exist");
		
		return new MyUserDecorator(dbuser);
	}

}
