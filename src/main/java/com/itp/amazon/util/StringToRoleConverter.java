package com.itp.amazon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.itp.amazon.entity.Role;
import com.itp.amazon.repository.RoleRepository;

@Component
public class StringToRoleConverter
        implements Converter<String, Role> {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public Role convert(String source) {
        return roleRepo.findById(Integer.parseInt(source))
                       .orElse(null);
    }
}