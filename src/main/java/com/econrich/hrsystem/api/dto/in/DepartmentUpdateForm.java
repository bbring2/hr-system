package com.econrich.hrsystem.api.dto.in;

import com.econrich.hrsystem.entity.Department;
import org.springframework.lang.Nullable;

public record DepartmentUpdateForm (
        String departmentName,
        Double salaryIncreaseRate
) {
    public static Department toEntity(DepartmentUpdateForm form) {
        return new Department();
    }
}
