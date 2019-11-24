package com.example.wellbeingtracker.Model;

public class YogaPose {
    private String name;
    private int iconId;
    private boolean expanded;
    private String description;

    public YogaPose(String name, int iconId, String description) {
        this.name = name;
        this.iconId = iconId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public String getDescription() {
        return description;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;

    }
}
