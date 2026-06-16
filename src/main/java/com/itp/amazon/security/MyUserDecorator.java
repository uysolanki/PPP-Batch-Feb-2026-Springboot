package com.itp.amazon.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.itp.amazon.entity.DBUser;
import com.itp.amazon.entity.Role;

public class MyUserDecorator implements UserDetails {

	DBUser user;
	public MyUserDecorator(DBUser user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
//	@Override
//	public boolean isAccountNonExpired() {
//		LocalDate accExpDate=user.getAccountExpiryDate();
//		LocalDate todaysDate=LocalDate.now();
//		if(accExpDate.isAfter(todaysDate))
//			return true;
//		else
//			return false;
//	}
//	
//	@Override
//	public boolean isAccountNonLocked() {
//		int lockedStatus=user.getAccountLockedStatus();
//		if(lockedStatus==1)
//			return true;
//		else
//			return false;
//	}
//	
//	@Override
//	public boolean isCredentialsNonExpired() {
//		LocalDate credExpDate=user.getCredExpiryDate();
//		LocalDate todaysDate=LocalDate.now();
//		if(credExpDate.isAfter(todaysDate))
//			return true;
//		else
//			return false;
//	}
//	@Override
//	public boolean isEnabled() {
//		int enabledStatus=user.getAccountEnabledStatus();
//		if(enabledStatus==1)
//			return true;
//		else
//			return false;
//	}

}
