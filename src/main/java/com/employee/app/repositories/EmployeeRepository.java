package com.employee.app.repositories;

import com.employee.app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
}
