package com.github.igorgabriel.model;

public enum Category {
    ACTION("Ação"), 
    COMEDY("Comédia"), 
    THRILLER("Suspense"), 
    SCI_FI("Ficção Científica"), 
    FANTASY("Fantasia");

    private String name;

    private Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
