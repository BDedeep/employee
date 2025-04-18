package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(String department);
    List<Employee> findByAgeGreaterThan(int age);
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);
}
