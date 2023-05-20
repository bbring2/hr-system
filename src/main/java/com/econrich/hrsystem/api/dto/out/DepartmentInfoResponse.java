package com.econrich.hrsystem.api.dto.out;

import lombok.Builder;

@Builder
public record DepartmentInfoResponse(
        Long id,
        String name,
        String managerFirstName,
        String managerLastName,
        String region,
        String country,
        String streetAddress,
        String postalCode,
        String city,
        String stateProvince
) {
}