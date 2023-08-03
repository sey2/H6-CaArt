package com.softeer.caart.domain.engine;

import com.softeer.caart.domain.Image;

import javax.persistence.*;

@Entity
@Table(name = "car_engine")
public class CarEngine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_engine_id")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(length = 30, nullable = false)
    private String maxPower;

    @Column(length = 30, nullable = false)
    private String maxTorque;

    @Embedded
    private Image image;
}
