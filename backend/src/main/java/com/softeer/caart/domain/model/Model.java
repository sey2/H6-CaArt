package com.softeer.caart.domain.model;

import com.softeer.caart.domain.bodytype.BodyType;
import com.softeer.caart.domain.engine.CarEngine;
import com.softeer.caart.domain.trim.Trim;
import com.softeer.caart.domain.wd.WheelDrive;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_engine_id", nullable = false)
    private CarEngine carEngine;

    @ManyToOne
    @JoinColumn(name = "body_type_id", nullable = false)
    private BodyType bodyType;

    @ManyToOne
    @JoinColumn(name = "wd_id", nullable = false)
    private WheelDrive wheelDrive;

    @ManyToOne
    @JoinColumn(name = "trim_id", nullable = false)
    private Trim trim;

    @Column(nullable = false)
    private Integer price;
}
