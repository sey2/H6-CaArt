package com.softeer.caart.domain.color;

import com.softeer.caart.domain.Image;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Embedded
    private Image image;
}
