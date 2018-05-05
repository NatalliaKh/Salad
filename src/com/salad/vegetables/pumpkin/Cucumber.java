package com.salad.vegetables.pumpkin;

import com.salad.vegetables.Color;

import java.io.BufferedWriter;
import java.io.IOException;

public class Cucumber extends PumpkinVegetable {

    public Cucumber(int weight) {
        super(16, weight, Color.GREEN);
    }

    public void cook(BufferedWriter writer) throws IOException {
        writer.write("Помыть и нарезать кубиками " + toString());
        writer.newLine();
    }

    public String toString() {
        return super.toString() + " огурец";
    }
}
