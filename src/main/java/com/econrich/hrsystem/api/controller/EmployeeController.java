package com.econrich.hrsystem.api.controller;

import com.econrich.hrsystem.api.dto.out.EmployeeInfoResponse;
import com.econrich.hrsystem.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @Operation(summary = "특정 사원의 현재 정보 조회하기 API", description = "특정 사원의 id 값을 Path variable로 받습니다.")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeInfoResponse> search(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(service.getEmployeeInformation(id));
    }

}
