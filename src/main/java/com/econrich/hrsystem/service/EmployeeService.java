package com.econrich.hrsystem.service;

import com.econrich.hrsystem.api.dto.in.EmployeeUpdateForm;
import com.econrich.hrsystem.api.dto.out.EmployeeInfoResponse;
import com.econrich.hrsystem.api.dto.out.JobHistoryResponse;
import com.econrich.hrsystem.entity.Department;
import com.econrich.hrsystem.entity.Employee;
import com.econrich.hrsystem.entity.JobHistory;
import com.econrich.hrsystem.exception.NotFoundEmployeeException;
import com.econrich.hrsystem.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final DepartmentService departmentService;

    public EmployeeService(EmployeeRepository repository, DepartmentService departmentService) {
        this.repository = repository;
        this.departmentService = departmentService;
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundEmployeeException("해당 id를 가진 사원을 찾을 수 없습니다."));
    }

    public EmployeeInfoResponse getEmployeeInformation(Long employeeId) {
        Employee employee = getById(employeeId);
        return EmployeeInfoResponse.of(employee);
    }

    public List<JobHistoryResponse> getEmployeeJobHistory(Long employeeId) {
        Employee employee = getById(employeeId);

        List<JobHistory> jobHistoryList = employee.getJobHistoryList();

        List<JobHistoryResponse> jobHistoryResponses = jobHistoryList
                .stream()
                .map(JobHistoryResponse::of)
                .collect(Collectors.toList());

        return jobHistoryResponses;
    }

    public List<EmployeeInfoResponse> updateSalary(Long departmentId, Double percentage) {
        Department department = departmentService.getById(departmentId);
        List<Employee> employees = repository.findAllByDepartment(department);

        for (Employee employee : employees) {
            employee.increaseSalary(percentage);
        }

        repository.saveAll(employees);

        return employees
                .stream()
                .map(EmployeeInfoResponse::of)
                .collect(Collectors.toList());
    }

    public EmployeeInfoResponse update(Long id, EmployeeUpdateForm form) {
        Employee employee = getById(id);

        employee.updateField(form.firstName(), employee::updateFirstName);
        employee.updateField(form.lastName(), employee::updateLastName);
        employee.updateField(form.email(), employee::updateEmail);
        employee.updateField(form.phoneNumber(), employee::updatePhoneNumber);

        repository.save(employee);

        return EmployeeInfoResponse.of(employee);
    }
}
