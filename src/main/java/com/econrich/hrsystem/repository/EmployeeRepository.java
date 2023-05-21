package com.econrich.hrsystem.repository;

import com.econrich.hrsystem.entity.Department;
import com.econrich.hrsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByDepartment(Department department);
}
