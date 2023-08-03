package com.softeer.caart.domain.option;

import com.softeer.caart.domain.tag.Tag;

import javax.persistence.*;

@Entity
@Table(name = "rel_car_option_tag")
public class OptionTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rel_car_option_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_option_id", nullable = false)
    private CarOption carOption;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;
}
