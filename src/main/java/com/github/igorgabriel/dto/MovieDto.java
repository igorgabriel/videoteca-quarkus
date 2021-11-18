package com.github.igorgabriel.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class MovieDto implements Serializable{
    private Long id;
    private String name;
    private String description;
    private String director;
    private String image;
    private int year;
    private String categoryName;
    private int duration;
}
