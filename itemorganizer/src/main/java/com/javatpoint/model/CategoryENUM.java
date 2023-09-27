package com.javatpoint.model;

import java.util.List;


public enum CategoryENUM {
    BEVERAGES(1, "Beverages"), SAUCES(2, "Sauces & Condiments"),
    BAKERY(3, "Bakery Items"), BATH_CLEANING(4, "Bath & Cleaning"),
    SNACKS(5, "Snacks"), OILS(6, "Oils"), GRAINS(7, "Grains"),
    PULSES(8, "Pulses"), SPICES(9, "Spices"), FLOUR(10, "Flour"),
    OTHER(11, "Other"), BREAKFAST(12, "Breakfast");

    private String enumName;
    private Integer enumId;

    private CategoryENUM(Integer enumId, String enumName) {
        this.setEnumId(enumId);
        this.setEnumName(enumName);
    }

    public String getEnumName() {
        return enumName;
    }

    public void setEnumName(String enumName) {
        this.enumName = enumName;
    }

    public Integer getEnumId() {
        return enumId;
    }

    public void setEnumId(Integer enumId) {
        this.enumId = enumId;
    }

}
