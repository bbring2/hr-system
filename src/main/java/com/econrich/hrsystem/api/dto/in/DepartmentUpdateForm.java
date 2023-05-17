package com.econrich.hrsystem.api.dto.in;

import com.econrich.hrsystem.entity.Department;
import org.springframework.lang.Nullable;

public record DepartmentUpdateForm (
        @Nullable Long locationId,
        @Nullable Long managerId,
        @Nullable String name
) {
    public static Department toEntity(DepartmentUpdateForm form) {
        return new Department();
    }
}
