package com.econrich.hrsystem.api.dto.out;

import com.econrich.hrsystem.entity.Employee;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record EmployeeInfoResponse (
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        LocalDate hireDate,
        Double salary,
        String commissionPct,
        String departmentName,
        String jobTitle,
        String managerFirstName,
        String managerLastName
) {
    public static EmployeeInfoResponse of(Employee employee) {
        return EmployeeInfoResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .hireDate(employee.getHireDate())
                .salary(Double.parseDouble(employee.getSalary()))
                .commissionPct(employee.getCommissionPct())
                .departmentName(employee.getDepartment().getName())
                .jobTitle(employee.getJob().getTitle())
                .managerFirstName(employee.getManager().getFirstName())
                .managerLastName(employee.getManager().getLastName())
                .build();
    }
}