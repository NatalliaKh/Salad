package com.salad;

import java.io.BufferedWriter;
import java.io.IOException;

public interface Cookable {
    void cook(BufferedWriter writer) throws IOException;
    double getCalories();
    int getWeight();
}

