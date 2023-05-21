package com.econrich.hrsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Entity
@Getter
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
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
    private BigDecimal salary;

    @Column(columnDefinition = "DECIMAL(2,2)")
    private BigDecimal commissionPct;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobHistory> jobHistoryList;

    public void updateCommissionPct(Double commissionPct) {
        this.commissionPct = BigDecimal.valueOf(commissionPct);
    }

    public void increaseSalary(Double commissionPct) {
        updateCommissionPct(commissionPct);
        this.salary = salary.add(salary.multiply(new BigDecimal(commissionPct)));
    }

    public void updateFirstName(String firstName) {
        if(!firstName.isEmpty() && !this.firstName.equals(firstName)) {
            this.firstName = firstName;
        }
    }

    public void updateLastName(String lastName) {
        if(!lastName.isEmpty() && !this.lastName.equals(lastName)) {
            this.lastName = lastName;
        }
    }

    public void updateEmail(String email) {
        if(!email.isEmpty() && !this.email.equals(email)) {
            this.email = email;
        }
    }

    public void updatePhoneNumber(String phoneNumber) {
        if(!phoneNumber.isEmpty() && !this.phoneNumber.equals(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    public <T> void updateField(T value, Consumer<T> update) {
        Optional.ofNullable(value).ifPresent(update);
    }

}
