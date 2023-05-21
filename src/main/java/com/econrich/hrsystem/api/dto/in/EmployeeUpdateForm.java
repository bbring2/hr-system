package com.econrich.hrsystem.api.dto.in;

import com.econrich.hrsystem.entity.Department;

public record EmployeeUpdateForm(
        String firstName,
        String lastName,
        String email,
        String phoneNumber
) {
}
