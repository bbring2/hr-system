package com.econrich.hrsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Embeddable
public class JobHistory {

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Employee employee;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Job job;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Department department;

}
