package com.econrich.hrsystem.api.dto.out;

import com.econrich.hrsystem.entity.Department;
import lombok.Builder;

@Builder
public record DepartmentInfoResponse(
        Long id,
        String name,
        String region,
        String country,
        String streetAddress,
        String postalCode,
        String city,
        String stateProvince
) {
    public static DepartmentInfoResponse of(Department department) {
        return DepartmentInfoResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .region(department.getLocation().getCountry().getRegion().getName())
                .country(department.getLocation().getCountry().getName())
                .streetAddress(department.getLocation().getStreetAddress())
                .postalCode(department.getLocation().getPostalCode())
                .city(department.getLocation().getCity())
                .stateProvince(department.getLocation().getStateProvince())
                .build();
    }
}