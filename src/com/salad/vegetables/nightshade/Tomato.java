package com.salad.vegetables.nightshade;

import com.salad.vegetables.Color;

public class Tomato extends NightshadeVegetable {

    public Tomato(int weight) {
        super(18, weight, Color.RED);
    }

    public void cook() {
        System.out.println("Помыть и нарезать " + toString());
    }

    public String toString() {
        return super.toString() + " томат";
    }
}
