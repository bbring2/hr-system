package com.econrich.hrsystem.api.dto.out;

import com.econrich.hrsystem.entity.JobHistory;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record JobHistoryResponse (
        LocalDate startDate,
        LocalDate endDate,
        String jobTitle,
        String departmentName
) {
    public static JobHistoryResponse of(JobHistory jobHistory) {
        return JobHistoryResponse.builder()
                .startDate(jobHistory.getStartDate())
                .endDate(jobHistory.getEndDate())
                .jobTitle(jobHistory.getJob().getTitle())
                .departmentName(jobHistory.getDepartment().getName())
                .build();
    }
}
