package com.itp.employee_management_system.service;

import com.itp.employee_management_system.entity.Employee;
import com.itp.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveStudent(Employee employee){
        return employeeRepository.save(employee);
    }
}
