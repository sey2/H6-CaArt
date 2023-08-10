package com.softeer.caart.domain.option.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "sub_option_info")
@Getter
public class SubOptionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_option_info_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_option_info_id", nullable = false)
    private BaseOptionInfo details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "additional_option_info_id", nullable = false)
    private AdditionalOptionInfo superOption;
}
