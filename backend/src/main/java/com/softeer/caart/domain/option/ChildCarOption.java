package com.softeer.caart.domain.option;

import com.softeer.caart.domain.Image;

import javax.persistence.*;

@Entity
@Table(name = "child_car_option")
public class ChildCarOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_car_option_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Embedded
    private Image image;

    @ManyToOne
    @JoinColumn(name = "car_option_id", nullable = false)
    private CarOption parentOption;
}
