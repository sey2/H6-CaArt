package com.softeer.caart.domain.tag;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TagType name;
}
