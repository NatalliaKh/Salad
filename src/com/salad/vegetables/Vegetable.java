package com.salad.vegetables;

import com.salad.Color;

public abstract class Vegetable {

    private final int caloricity;
    private int weight;
    private Color color;

    public Vegetable(int caloricity, int weight, Color color) {
        this.caloricity = caloricity;
        this.weight = weight;
        this.color = color;
    }

    public abstract String getVegetableTypeDescription();
}
