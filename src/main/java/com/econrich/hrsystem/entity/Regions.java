package com.econrich.hrsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Long id;

    @Column(name = "region_name", columnDefinition = "varchar(25)")
    private String name;

}
