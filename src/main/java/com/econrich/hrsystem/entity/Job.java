package com.econrich.hrsystem.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @Column(name = "job_id", columnDefinition = "VARCHAR(10)")
    private String id;

    @Column(name = "job_title", columnDefinition = "VARCHAR(35)")
    private String title;

    @Column(name = "min_salary", columnDefinition = "DECIMAL(8)")
    private String minSalary;

    @Column(name = "max_salary", columnDefinition = "DECIMAL(8)")
    private String maxSalary;

    @ElementCollection
    private List<JobHistory> jobHistoryList;

}
