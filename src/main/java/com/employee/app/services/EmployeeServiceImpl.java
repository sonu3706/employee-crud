package com.employee.app.services;

import com.employee.app.models.Employee;
import com.employee.app.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) throws Exception{
        if (!employeeRepository.existsById(employee.getId())) {
          employee =  employeeRepository.save(employee);
        } else {
            throw new Exception("Employee already exists");
        }
        return employee;
    }

    @Override
    public Employee getEmployeeById(int id) throws  Exception {
        Employee fetchedEmployee;
        Optional<Employee> employeeOptional = employeeRepository.findById(BigInteger.valueOf(id));
        if (employeeOptional.isPresent()) {
            fetchedEmployee = employeeOptional.get();
        } else {
            throw new Exception("Employee not found");
        }
        return fetchedEmployee;
    }

    @Override
    public Employee updateEmployeeById(Employee employee, int id) throws Exception {
        Employee fetchedEmployee;
        Optional<Employee> employeeOptional = employeeRepository.findById(BigInteger.valueOf(id));
        if (employeeOptional.isPresent()) {
            fetchedEmployee = employeeOptional.get();
            fetchedEmployee.setEmail(employee.getEmail());
            fetchedEmployee.setFirstName(employee.getFirstName());
            fetchedEmployee.setLastName(employee.getLastName());
            fetchedEmployee.setPhone(employee.getPhone());

           fetchedEmployee = employeeRepository.save(fetchedEmployee);
        } else {
            throw new Exception("Employee not found");
        }
        return fetchedEmployee;
    }

    @Override
    public Boolean deleteEmployeeById(int id) throws Exception {
        Optional<Employee> employeeOptional = employeeRepository.findById(BigInteger.valueOf(id));
        if (employeeOptional.isPresent()) {
            employeeRepository.delete(employeeOptional.get());
            return true;

        } else {
            throw new Exception("Employee not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
