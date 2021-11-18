package com.github.igorgabriel.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Movie extends PanacheEntity {
    private String name;
    @Lob
    private String description;
    private String director;
    private String image;
    private int year;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int duration;

}
