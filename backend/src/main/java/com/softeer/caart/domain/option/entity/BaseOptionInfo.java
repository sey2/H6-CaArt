package com.softeer.caart.domain.option.entity;

import com.softeer.caart.domain.Image;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "base_option_info")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseOptionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_option_info_id")
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Embedded
    private Image image;

    @OneToMany(mappedBy = "option")
    private List<OptionTag> tags;

    @Builder
    public BaseOptionInfo(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.image = Image.from(imageUrl);
    }
}
