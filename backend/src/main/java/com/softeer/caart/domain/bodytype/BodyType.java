package com.softeer.caart.domain.bodytype;

import com.softeer.caart.domain.Image;

import javax.persistence.*;

@Entity
@Table(name = "body_type")
public class BodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_type_id")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Embedded
    private Image image;
}
