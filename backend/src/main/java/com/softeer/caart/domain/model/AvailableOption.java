package com.softeer.caart.domain.model;

import com.softeer.caart.domain.option.CarOption;

import javax.persistence.*;

@Entity
@Table(name = "rel_model_car_option")
public class AvailableOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rel_model_car_option_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_option_id", nullable = false)
    private CarOption carOption;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
}
