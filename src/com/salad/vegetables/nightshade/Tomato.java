package com.salad.vegetables.nightshade;

import com.salad.vegetables.Color;

import java.io.BufferedWriter;
import java.io.IOException;

public class Tomato extends NightshadeVegetable {

    public Tomato(int weight) {
        super(18, weight, Color.RED);
    }

    public void cook(BufferedWriter writer) throws IOException {
        writer.write("Помыть и нарезать " + toString());
        writer.newLine();
    }

    public String toString() {
        return super.toString() + " томат";
    }
}
