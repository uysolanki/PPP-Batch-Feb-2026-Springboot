package com.itp.employee_management_system.controller;

import com.itp.employee_management_system.dto.DepartmentDTO;
import com.itp.employee_management_system.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
@Validated
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDepartments")
    public ResponseEntity<List<DepartmentDTO>> saveDepartments(@Valid @RequestBody List<@Valid DepartmentDTO> departmentDTOS) {
        return new ResponseEntity<List<DepartmentDTO>>(departmentService.saveDepartments(departmentDTOS),HttpStatus.CREATED);
    }

    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDTO> saveDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        return new ResponseEntity<DepartmentDTO>(departmentService.saveDepartment(departmentDTO),HttpStatus.CREATED);
    }

    @GetMapping("/getDepartments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        return new ResponseEntity<List<DepartmentDTO>>(departmentService.getDepartments(),HttpStatus.OK);
    }

    @GetMapping("/getDepartment/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Integer departmentId) {
        return new ResponseEntity<DepartmentDTO>(departmentService.getDepartment(departmentId),HttpStatus.OK);
    }

    @GetMapping("/getDepartmentEmployeeCount")
    public ResponseEntity<Map<String, Integer>> getDepartmentEmployeeCount(){
        return new ResponseEntity<Map<String, Integer>>(departmentService.getDepartmentEmployeeCount(), HttpStatus.OK);
    }
}
