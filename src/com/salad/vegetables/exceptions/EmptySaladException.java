package com.salad.vegetables.exceptions;

public class EmptySaladException extends Exception {

    public EmptySaladException() {
        super("Салат пуст, пожалуйста, добавьте овощи");
    }
}
