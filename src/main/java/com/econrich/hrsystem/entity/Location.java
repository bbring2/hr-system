package com.econrich.hrsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", columnDefinition = "CHAR(2)")
    private Country country;

    @Column(name = "street_address", columnDefinition = "VARCAHR(40)")
    private String streetAddress;

    @Column(name = "postal_code", columnDefinition = "VARCHAR(12)")
    private String postalCode;

    @Column(columnDefinition = "VARCHAR(30)")
    private String city;

    @Column(name = "state_province", columnDefinition = "VARCHAR(25)")
    private String stateProvince;

}
