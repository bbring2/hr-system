package com.econrich.hrsystem.api.dto.out;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record JobHistoryResponse (
         LocalDate startDate,
         LocalDate endDate,
         String jobTitle,
         String departmentName
) {
}
