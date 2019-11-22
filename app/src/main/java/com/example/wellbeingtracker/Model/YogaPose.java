package com.example.wellbeingtracker.Model;

public class YogaPose {
    private String name;
    private int iconId;

    public YogaPose(String name, int iconId) {
        this.name = name;
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public int getIconId() {
        return iconId;
    }
}
