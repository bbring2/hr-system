package com.econrich.hrsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "job_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Job job;

    @JoinColumn(name = "department_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Department department;

    @JoinColumn(name = "manager_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Employee manager;

    @Column(name = "first_name", columnDefinition = "VARCHAR(20)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(25)")
    private String lastName;

    @Column(columnDefinition = "VARCHAR(25)")
    private String email;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(20)")
    private String phoneNumber;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(columnDefinition = "DECIMAL(8,2)")
    private String salary;

    @Column(columnDefinition = "DECIMAL(2,2)")
    private String commissionPct;

    @ElementCollection
    private List<JobHistory> jobHistoryList;

}
