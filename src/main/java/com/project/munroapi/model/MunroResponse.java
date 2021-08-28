package com.project.munroapi.model;

public class MunroResponse {

    private String munroName;

    private double heightInMeters;

    private String hillCategory;

    private String gridReference;

    public MunroResponse(String munroName, double heightInMeters, String hillCategory, String gridReference) {
        this.munroName = munroName;
        this.heightInMeters = heightInMeters;
        this.hillCategory = hillCategory;
        this.gridReference = gridReference;
    }

    public String getMunroName() {
        return munroName;
    }

    public void setMunroName(String munroName) {
        this.munroName = munroName;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public void setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
    }

    public String getHillCategory() {
        return hillCategory;
    }

    public void setHillCategory(String hillCategory) {
        this.hillCategory = hillCategory;
    }

    public String getGridReference() {
        return gridReference;
    }

    public void setGridReference(String gridReference) {
        this.gridReference = gridReference;
    }
}
