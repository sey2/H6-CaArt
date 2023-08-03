package com.softeer.caart.domain.trim;

import com.softeer.caart.domain.Image;

import javax.persistence.*;

@Entity
public class Trim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trim_id")
    private Long id;

    @Embedded
    private Image image;
}
