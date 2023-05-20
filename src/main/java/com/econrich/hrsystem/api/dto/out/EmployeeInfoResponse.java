package com.econrich.hrsystem.api.dto.out;

import java.time.LocalDate;

public record EmployeeInfoResponse (
        Long id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        LocalDate hireDate,
        Double salary,
        Double commissionPct,
        String departmentName,
        String jobTitle,
        String managerFirstName,
        String managerLastName

) {
}