package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    // Create or update employee
    public Employee save(Employee emp) {
        return repository.save(emp);
    }

    // Get all employees
    public List<Employee> findAll() {
        return repository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    // Delete employee
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Filters
    public List<Employee> getByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public List<Employee> getByAgeGreaterThan(int age) {
        return repository.findByAgeGreaterThan(age);
    }

    public List<Employee> getBySalaryRange(double minSalary, double maxSalary) {
        return repository.findBySalaryBetween(minSalary, maxSalary);
    }

    public List<Employee> filterEmployees(String department, Integer age, Double minSalary, Double maxSalary) {
        List<Employee> employees = repository.findAll();

        if (department != null) {
            employees = employees.stream()
                    .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                    .toList();
        }

        if (age != null) {
            employees = employees.stream()
                    .filter(emp -> emp.getAge() > age)
                    .toList();
        }

        if (minSalary != null && maxSalary != null) {
            employees = employees.stream()
                    .filter(emp -> emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary)
                    .toList();
        }

        return employees;
    }
}
