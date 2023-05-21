package com.econrich.hrsystem.api.controller;

import com.econrich.hrsystem.api.dto.in.EmployeeUpdateForm;
import com.econrich.hrsystem.api.dto.out.EmployeeInfoResponse;
import com.econrich.hrsystem.api.dto.out.JobHistoryResponse;
import com.econrich.hrsystem.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/{id}")
    @Operation(summary = "특정 사원의 현재 정보 조회하기 API", description = "특정 사원의 id 값을 Path variable로 받습니다.")
    public ResponseEntity<EmployeeInfoResponse> search(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(service.getEmployeeInformation(id));
    }

    @GetMapping("/job-history/{id}")
    @Operation(summary = "특정 사원의 이력정보 조회하기 API", description = "특정 사원의 id 값을 Path variable로 받습니다.")
    public ResponseEntity<List<JobHistoryResponse>> searchJobHistory(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(service.getEmployeeJobHistory(id));
    }

    @PatchMapping("/salary/{dept-id}")
    @Operation(summary = "특정 부서의 급여를 특정 비율로 인상하기 API", description = "특정 부서의 id 값을 Path variable로 받고, 비율을 String으로 받습니다.")
    public ResponseEntity<List<EmployeeInfoResponse>> updateSalary(@PathVariable ("dept-id") Long departmentId,
                                                                   @RequestParam ("percentage") Double commissionPct) {
        return ResponseEntity.ok(service.updateSalary(departmentId, commissionPct));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "사원 정보 수정하기 API", description = "특정 사원의 id 값을 Path variable로 받아 수정할 수 있습니다.")
    public ResponseEntity<EmployeeInfoResponse> update(@PathVariable ("id") Long id,
                                                       @RequestBody EmployeeUpdateForm request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}
