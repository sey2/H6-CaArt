package com.softeer.caart.domain.wd;

import com.softeer.caart.domain.Image;

import javax.persistence.*;

@Entity
@Table(name = "wheel_drive")
public class WheelDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wd_id")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Embedded
    private Image image;
}
