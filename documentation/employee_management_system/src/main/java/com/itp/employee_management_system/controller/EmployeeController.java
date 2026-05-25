package com.itp.employee_management_system.controller;

import com.itp.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/test")
    private ResponseEntity<String> test() {
        return new ResponseEntity<String>("Testing Spring Boot Application", HttpStatus.OK);
    }

//    @GetMapping("/getStudent")
//    private Employee getStudent() {
//        int studentId = 3;
//        return employeeService.getStudent(studentId);
//    }
//
//    @GetMapping("/getStudent1")
//    private ResponseEntity<?> getStudent1() {
//        int studentId = 20;
//        try {
//            return new ResponseEntity<Employee>(employeeService.getStudent1(studentId), HttpStatus.CREATED);
//        } catch (RuntimeException e1) {
//            return new ResponseEntity<String>("Employee with roll number " + studentId + " does not exist",
//                    HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getStudent2")
//    private ResponseEntity<?> getStudent2() {
//        int studentId = 20;
//        try {
//            return new ResponseEntity<Employee>(employeeService.getStudent2(studentId), HttpStatus.CREATED);
//        } catch (ResourceNotFoundException e1) {
//            return new ResponseEntity<String>(e1.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/getStudent3/{studentId}")
//    private ResponseEntity<?> getStudent3(@PathVariable int studentId) {
//        return new ResponseEntity<Employee>(employeeService.getStudent2(studentId), HttpStatus.CREATED);
//
//    }
//
//    @GetMapping("/getStudentsGreaterThanPercentage/{inputPercentage}")
//    private List<Employee> getStudentsGreaterThanPercentage(@PathVariable double inputPercentage) {
//        return employeeService.getStudentsGreaterThanPercentage(inputPercentage);
//    }
//
//    @GetMapping("/getStudentsBetweenPercentage/{start}/{end}")
//    private List<Employee> getStudentsBetweenPercentage(@PathVariable double start, @PathVariable double end) {
//        return employeeService.getStudentsBetweenPercentage(start, end);
//    }
//
//    @GetMapping("/getStudentsFromDepartment/{inputDepartment}")
//    private List<Employee> getStudentsFromDepartment(@PathVariable String inputDepartment) {
//        return employeeService.getStudentsFromDepartment(inputDepartment);
//    }
//
//    @GetMapping("/getAllStudents")
//    private List<Employee> getAllStudents() {
//        return employeeService.getAllStudents();
//    }
//
//    @GetMapping("/getAllStudents1")
//    private ResponseEntity<List<Employee>> getAllStudents1() {
//        return new ResponseEntity<List<Employee>>(employeeService.getAllStudents(), HttpStatus.OK);
//    }
//
//    @PostMapping("/saveStudentGetString")
//    private String saveStudentGetString() {
//        Employee student = Employee.builder().sname("David").dname("MBA").per(85.89).build();
//        employeeService.saveStudentGetString(student);
//        return "Record Saved";
//    }
//
//    @PostMapping("/saveStudentGetObject")
//    private Employee saveStudentGetObject() {
//        Employee student = Employee.builder().sname("Chris").dname("Engineering").per(76.89).build();
//        return employeeService.saveStudentGetObject(student);
//    }
//
//    @PostMapping("/saveStudentGetResponseEntity")
//    private ResponseEntity<Employee> saveStudentGetResponseEntity() {
//        Employee newStudent = Employee.builder().sname("Mangesh").dname("Teacher").per(96.89).build();
//        Employee savedStudent = employeeService.saveStudentGetObject(newStudent);
//        return new ResponseEntity<Employee>(savedStudent, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/saveStudentUsingRequestParam")
//    private Employee saveStudentUsingRequestParam(@RequestParam("a") String studentName,
//                                                 @RequestParam("b") String departmentName, @RequestParam("c") double percentage) {
//        Employee student = Employee.builder().sname(studentName).dname(departmentName).per(percentage).build();
//        return employeeService.saveStudentGetObject(student);
//    }
//
//    @PostMapping("/saveStudentUsingRequestParam1")
//    private Employee saveStudentUsingRequestParam1(@RequestParam String studentName, @RequestParam String departmentName,
//                                                  @RequestParam double percentage) {
//        Employee student = Employee.builder().sname(studentName).dname(departmentName).per(percentage).build();
//        return employeeService.saveStudentGetObject(student);
//    }
//
//    @PostMapping("/saveStudentUsingRequestParam2")
//    private ResponseEntity<Employee> saveStudentUsingRequestParam2(@RequestParam("a") String studentName,
//                                                                  @RequestParam("b") String departmentName, @RequestParam("c") double percentage) {
//        Employee student = Employee.builder().sname(studentName).dname(departmentName).per(percentage).build();
//        return new ResponseEntity<Employee>(employeeService.saveStudentGetObject(student), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/saveStudentUsingPathVariable/{a}/{b}/{c}")
//    private Employee saveStudentUsingPathVariable(@PathVariable("a") String studentName,
//                                                 @PathVariable("b") String departmentName, @PathVariable("c") double percentage) {
//        Employee student = Employee.builder().sname(studentName).dname(departmentName).per(percentage).build();
//        return employeeService.saveStudentGetObject(student);
//    }
//
//    @PostMapping("/saveStudentUsingPathVariable1/{studentName}/{departmentName}/{percentage}")
//    private Employee saveStudentUsingPathVariable1(@PathVariable String studentName, @PathVariable String departmentName,
//                                                  @PathVariable double percentage) {
//        Employee student = Employee.builder().sname(studentName).dname(departmentName).per(percentage).build();
//        return employeeService.saveStudentGetObject(student);
//    }
//
//    @PostMapping("/saveStudentRequestBody")
//    private Employee saveStudentRequestBody(@RequestBody DepartmentDTO departmentDTO) {
//        return employeeService.saveStudent(departmentDTO);
//    }
//
//    @GetMapping("/getStudentsByPage/{pageNumber}/{pageSize}")
//    public Page<Employee> getStudentsByPage(@PathVariable int pageNumber, @PathVariable int pageSize) {
//        return employeeService.getStudentsByPage(pageNumber, pageSize);
//    }
//
//    @GetMapping("/getStudentsByPageSorted/{pageNumber}/{pageSize}/{fieldName}")
//    public Page<Employee> getStudentsByPageSorted(@PathVariable int pageNumber, @PathVariable int pageSize,
//                                                 @PathVariable String fieldName) {
//        return employeeService.getStudentsByPageSorted(pageNumber, pageSize, fieldName);
//    }
//
//    @DeleteMapping("/deleteStudent/{inputId}")
//    public ResponseEntity<String> deleteStudent(@PathVariable int inputId) {
//        employeeService.deleteStudent(inputId);
//        return new ResponseEntity<String>("Employee with id " + inputId + " is deleted", HttpStatus.OK);
//    }
//
//    @PutMapping("/updateStudent/{inputId}")
//    public ResponseEntity<Employee> updateStudent(@PathVariable int inputId, @RequestBody Employee newValues) {
//        Employee updatedStudent = employeeService.updateStudent(inputId, newValues);
//        return new ResponseEntity<Employee>(updatedStudent, HttpStatus.OK);
//    }
//
//    @PostMapping("/saveStudentUsingDTO")
//    public ResponseEntity<StudentDTO> saveStudentUsingDTO(@RequestBody StudentDTO studentDTO) {
//        return new ResponseEntity<StudentDTO>(employeeService.saveStudentUsingDTO(studentDTO), HttpStatus.OK);
//    }
}
