package com.salad.vegetables;

public enum Color {
    RED, YELLOW, GREEN;

    public String toString() {
        switch (this) {
            case RED:
                return "красный";
            case YELLOW:
                return "желтый";
            case GREEN:
                return "зеленый";
            default:
                return super.toString();
        }
    }
}
