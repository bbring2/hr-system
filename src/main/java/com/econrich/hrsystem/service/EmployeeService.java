package com.econrich.hrsystem.service;

import com.econrich.hrsystem.api.dto.out.EmployeeInfoResponse;
import com.econrich.hrsystem.entity.Employee;
import com.econrich.hrsystem.exception.NotFoundEmployeeException;
import com.econrich.hrsystem.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundEmployeeException("해당 id를 가진 사원을 찾을 수 없습니다."));
    }

    public EmployeeInfoResponse getEmployeeInformation(Long employeeId) {
        Employee employee = getById(employeeId);
        return EmployeeInfoResponse.of(employee);
    }
}
