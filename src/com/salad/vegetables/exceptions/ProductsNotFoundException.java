package com.salad.vegetables.exceptions;

public class ProductsNotFoundException extends Exception {

    public ProductsNotFoundException() {
        super("По заданным критериям продукты не найдены");
    }
}
