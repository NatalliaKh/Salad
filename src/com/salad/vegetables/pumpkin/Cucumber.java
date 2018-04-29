package com.salad.vegetables.pumpkin;

import com.salad.vegetables.Color;

public class Cucumber extends PumpkinVegetable {

    public Cucumber(int weight) {
        super(16, weight, Color.GREEN);
    }

    public void cook() {
        System.out.println("Помыть и нарезать кубиками " + toString());
    }

    public String toString() {
        return super.toString() + " огурец";
    }
}
