package com.econrich.hrsystem.service;

import com.econrich.hrsystem.api.dto.out.DepartmentInfoResponse;
import com.econrich.hrsystem.entity.Department;
import com.econrich.hrsystem.exception.NotFoundDepartmentException;
import com.econrich.hrsystem.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department getById(Long id) {
        return repository.findById(id)
                .orElseThrow(NotFoundDepartmentException::new);
    }

    public List<DepartmentInfoResponse> getAllDepartments() {
        List<Department> departments = repository.findAll();

        List<DepartmentInfoResponse> departmentInfoResponses = departments
                .stream()
                .map(department -> {
                    if (department.getLocation() != null && department.getLocation().getCountry() != null && department.getLocation().getCountry().getRegion() != null) {
                        return DepartmentInfoResponse.of(department);
                    } else {
                        return null;
                    }
                })
                .collect(Collectors.toList());


        return departmentInfoResponses;
    }

}