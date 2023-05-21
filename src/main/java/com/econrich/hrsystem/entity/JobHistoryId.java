package com.econrich.hrsystem.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class JobHistoryId implements Serializable {

    private Long employee;

}