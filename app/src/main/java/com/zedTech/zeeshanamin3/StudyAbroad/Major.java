package com.zedTech.zeeshanamin3.StudyAbroad;

public class Major {
    // Major  objects for list view
    private String name;
    private String category;
    private String description;

    // Basic Constructor
    public Major(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
