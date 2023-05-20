package com.econrich.hrsystem.service;

import com.econrich.hrsystem.entity.Employee;
import com.econrich.hrsystem.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepository repository, DepartmentService departmentService) {
        this.repository = repository;
        this.departmentService = departmentService;
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }


}
