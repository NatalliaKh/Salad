package com.salad;

import com.salad.vegetables.nightshade.Pepper;
import com.salad.vegetables.nightshade.Tomato;
import com.salad.vegetables.pumpkin.Cucumber;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите количество томатов:");
        Scanner scanner = new Scanner(System.in);
        int tomatoAmount = scanner.nextInt();
        System.out.println("Введите количество огурцов:");
        int cucumberAmount = scanner.nextInt();
        System.out.println("Введите количество перца:");
        int peperAmount = scanner.nextInt();
        Cookable[] products = new Cookable[tomatoAmount + cucumberAmount + peperAmount];
        int productAmount = 0;
        for (int i = 0; i < tomatoAmount; i++) {
            products[productAmount] = new Tomato(getRandomWeight(50, 150));
            productAmount++;
        }
        for (int i = 0; i < cucumberAmount; i++) {
            products[productAmount] = new Cucumber(getRandomWeight(50, 150));
            productAmount++;
        }
        for (int i = 0; i < peperAmount; i++) {
            products[productAmount] = new Pepper(getRandomWeight(50, 150));
            productAmount++;
        }
        Salad salad = new Salad(products);
        salad.cook();
        System.out.printf("Калорийность вашего салата: %.2f калорий\n", salad.getCalories());
        Cookable[] sortedProducts = salad.sortProductsByWeight();
        System.out.println("Отсортированные по весу овощи:");
        for (Cookable cookable : sortedProducts) {
            System.out.println(cookable.toString());
        }
        List<Cookable> filteredProducts = salad.findProducts(18, 23, 50, 120);
        System.out.println("Найденые овощи с калориями от 18 до 23 и весом от 50 до 120 грамм:");
        for (Cookable cookable : filteredProducts) {
            System.out.println(cookable.toString());
        }
    }

    public static int getRandomWeight(int minimumWeight, int maximumWeight) {
        Random random = new Random();
        return random.nextInt(maximumWeight - minimumWeight) + minimumWeight;
    }
}
