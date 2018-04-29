package com.salad.vegetables;

import com.salad.Cookable;

public abstract class Vegetable implements Cookable {

    private final int caloricity;
    private int weight;
    private Color color;

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public Vegetable(int caloricity, int weight, Color color) {
        this.caloricity = caloricity;
        this.weight = weight;
        this.color = color;
    }

    public abstract String getVegetableTypeDescription();

    public double getCalories() {
        return (weight / 100.0) * caloricity;
    }

    public String toString() {
        return getColor().toString() + " " + String.valueOf(weight) + " граммовый";
    }
}
