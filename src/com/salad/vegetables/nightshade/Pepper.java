package com.salad.vegetables.nightshade;

import com.salad.vegetables.Color;

public class Pepper extends NightshadeVegetable {

    public Pepper(int weight) {
        super(27, weight, Color.YELLOW);
    }

    public void cook() {
        System.out.println("Помыть и нарезать полосочками " + toString());
    }

    public String toString() {
        return super.toString() + " перец";
    }
}
