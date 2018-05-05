package com.salad.vegetables.exceptions;

// некорректное количество овощей
public class InvalidVegetableAmountException extends Exception {

    public InvalidVegetableAmountException(String vegetableType) {
        super("Некорректное количество " + vegetableType + " - должно быть не отрицательным");
    }
}
