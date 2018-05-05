package com.salad;

import com.salad.vegetables.Color;
import com.salad.vegetables.exceptions.EmptySaladException;
import com.salad.vegetables.exceptions.ProductsNotFoundException;

import java.util.*;

public class Salad {

    private Cookable[] products;

    public Salad(Cookable[] products) throws EmptySaladException {
        if (products.length == 0) {
            throw new EmptySaladException();
        }
        this.products = products;
    }

    public void cook() {
        System.out.println("Мы готовим салат:");
        for (Cookable product : products) {
            product.cook();
        }
        System.out.println("Все перемешать\nПриятного аппетита!");
    }

    public double getCalories() {
        double calories = 0.0;
        for (Cookable product : products) {
            calories += product.getCalories();
        }
        return calories;
    }

    public Cookable[] sortProductsByWeight() {
        Arrays.sort(products, new Comparator<Cookable>() {

            public int compare(Cookable o1, Cookable o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });
        return products;
    }
    public List<Cookable> findProducts(int minimalCalories, int maximumCalories, int minimalWeight, int maximumWeight) throws ProductsNotFoundException {
        List<Cookable> filteredProducts = new ArrayList<>();
        for (Cookable product : products) {
            if (product.getCalories() >= minimalCalories
                    && product.getCalories() <= maximumCalories
                    && product.getWeight() >= minimalWeight
                    && product.getWeight() <= maximumWeight) {
                filteredProducts.add(product);
            }
        }
        if (filteredProducts.isEmpty()) {
            throw new ProductsNotFoundException();
        }
        return filteredProducts;
    }
}
