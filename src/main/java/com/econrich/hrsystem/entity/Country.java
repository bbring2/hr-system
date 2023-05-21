package com.econrich.hrsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private String id;

    @JoinColumn(name = "region_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Regions region;

    @Column(name = "country_name", columnDefinition = "VARCHAR(40)")
    private String name;

}
