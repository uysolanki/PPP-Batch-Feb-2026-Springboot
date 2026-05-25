package com.itp.employee_management_system.service;

import com.itp.employee_management_system.dto.DepartmentDTO;
import com.itp.employee_management_system.entity.Department;
import com.itp.employee_management_system.exception.ResourceNotFoundException;
import com.itp.employee_management_system.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<DepartmentDTO> saveDepartments(List<DepartmentDTO> departmentDTOS){
        List<Department> departments = departmentDTOS
                .stream()
                .map(departmentDTO -> modelMapper.map(departmentDTO, Department.class))
                .toList();
        departments.forEach(department -> {
            department.getEmployees().forEach(employee -> {
                employee.setDepartment(department);

                employee.getAddresses().forEach(address -> address.setEmployee(employee));
            });
        });
        List<Department> savedDepartments = departmentRepository.saveAll(departments);
        List<DepartmentDTO> savedDepartmentDTOS =  savedDepartments
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .toList();
        return savedDepartmentDTOS;
    }

    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO){
        Department department = modelMapper.map(departmentDTO, Department.class);
            department.getEmployees().forEach(employee -> {
                employee.setDepartment(department);

                employee.getAddresses().forEach(address -> address.setEmployee(employee));
            });
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDTO savedDepartmentDTO =  modelMapper.map(savedDepartment, DepartmentDTO.class);
        return savedDepartmentDTO;
    }

    public List<DepartmentDTO> getDepartments(){
        List<Department> databaseDepartments =  departmentRepository.findAll();
        List<DepartmentDTO> databaseDepartmentDTOS = databaseDepartments
                .stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .toList();
        return databaseDepartmentDTOS;
    }

    public DepartmentDTO getDepartment(Integer departmentId) throws ResourceNotFoundException {
        if(departmentRepository.existsById(departmentId)){
            Department department =  departmentRepository.findById(departmentId).get();
            DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
            return departmentDTO;
        }
        throw new ResourceNotFoundException("Resource not available in database");
    }

    public Map<String, Integer> getDepartmentEmployeeCount(){
        Map<String, Integer> departmentEmployeeCount = new HashMap<>();
        List<Department> databaseDepartments =  departmentRepository.findAll();
        databaseDepartments.forEach(department -> departmentEmployeeCount.put(department.getDepartmentName(), department.getEmployeeCount()));
        return departmentEmployeeCount;
    }
}
