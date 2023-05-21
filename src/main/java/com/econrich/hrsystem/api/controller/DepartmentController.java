package com.econrich.hrsystem.api.controller;

import com.econrich.hrsystem.api.dto.out.DepartmentInfoResponse;
import com.econrich.hrsystem.api.dto.out.EmployeeInfoResponse;
import com.econrich.hrsystem.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    @Operation(summary = "부서 및 위치 정보 조회하기 API", description = "전체 부서에 대한 정보를 받습니다.")
    @GetMapping
    public ResponseEntity<List<DepartmentInfoResponse>> fetch() {
        return ResponseEntity.ok(service.getAllDepartments());
    }
}
