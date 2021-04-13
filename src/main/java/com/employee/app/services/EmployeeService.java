package com.employee.app.services;

import com.employee.app.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(int id) throws Exception;

    Employee updateEmployeeById(Employee employee, int id) throws Exception;

    Boolean deleteEmployeeById(int id) throws Exception;

    List<Employee> getAllEmployees() throws Exception;
}
