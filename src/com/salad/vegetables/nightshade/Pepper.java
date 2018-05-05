package com.salad.vegetables.nightshade;

import com.salad.vegetables.Color;

import java.io.BufferedWriter;
import java.io.IOException;

public class Pepper extends NightshadeVegetable {

    public Pepper(int weight) {
        super(27, weight, Color.YELLOW);
    }

    public void cook(BufferedWriter writer) throws IOException {
        writer.write("Помыть и нарезать полосочками " + toString());
        writer.newLine();
    }

    public String toString() {
        return super.toString() + " перец";
    }
}
