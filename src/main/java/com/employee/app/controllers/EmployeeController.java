package com.employee.app.controllers;

import com.employee.app.models.Employee;
import com.employee.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = ResponseEntity.ok(employeeService.addEmployee(employee));
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(409).body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") int id) {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = ResponseEntity.ok(employeeService.getEmployeeById(id));
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(409).body(e.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable("id") int id, @RequestBody Employee employee) {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = ResponseEntity.ok(employeeService.updateEmployeeById(employee, id));
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(409).body(e.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") int id) {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = ResponseEntity.ok(employeeService.deleteEmployeeById(id));
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(409).body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEmployees() {
        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (Exception e) {
            responseEntity = ResponseEntity.status(409).body(e.getMessage());
        }
        return responseEntity;
    }
}
