package com.softeer.caart.domain.trim;

import com.softeer.caart.domain.color.Color;

import javax.persistence.*;

@Entity
@Table(name = "rel_trim_color")
public class AvailableColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rel_trim_color_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trim_id", nullable = false)
    private Trim trim;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
}
