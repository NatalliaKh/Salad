package com.salad;

import com.salad.storage.DatabaseStorage;
import com.salad.storage.JSONStorage;
import com.salad.storage.StorageSource;
import com.salad.vegetables.exceptions.EmptySaladException;
import com.salad.vegetables.exceptions.InvalidVegetableAmountException;
import com.salad.vegetables.exceptions.ProductsNotFoundException;
import com.salad.vegetables.nightshade.Pepper;
import com.salad.vegetables.nightshade.Tomato;
import com.salad.vegetables.pumpkin.Cucumber;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = null;
        BufferedWriter writer = null;
        try {
            System.out.println("Введите источник данных( 1 - база данных, 2 - json файл):");
            scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            if (userChoice != 1 && userChoice != 2) {
                throw new InputMismatchException();
            }
            StorageSource source = (userChoice == 1 ) ? new DatabaseStorage() : new JSONStorage();
            int tomatoAmount = source.getTomatoAmount();
            if (tomatoAmount < 0) {
                throw new InvalidVegetableAmountException("томатов");
            }
            int cucumberAmount = source.getCucumberAmount();
            if (cucumberAmount < 0) {
                throw new InvalidVegetableAmountException("огурцов");
            }
            int peperAmount = source.getPepperAmount();
            if (peperAmount < 0) {
                throw new InvalidVegetableAmountException("перцев");
            }
            source.cleanUp();
            Cookable[] products = new Cookable[tomatoAmount + cucumberAmount + peperAmount];
            int productAmount = 0;
            for (int i = 0; i < tomatoAmount; i++) {
                products[productAmount] = new Tomato(getRandomWeight(50, 150));
                productAmount++;
            }
            for (int i = 0; i < cucumberAmount; i++) {
                try {
                    products[productAmount] = new Cucumber(getRandomWeight(50, 150));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Вышли за пределы массива");
                }
                productAmount++;
            }
            for (int i = 0; i < peperAmount; i++) {
                products[productAmount] = new Pepper(getRandomWeight(50, 150));
                productAmount++;
            }
            writer = new BufferedWriter(new FileWriter("output.txt"));
            Salad salad = new Salad(products);
            salad.cook(writer);
            writer.write(String.format("Калорийность вашего салата: %.2f калорий", salad.getCalories()));
            writer.newLine();
            Cookable[] sortedProducts = salad.sortProductsByWeight();
            writer.write("Отсортированные по весу овощи:");
            writer.newLine();
            for (Cookable cookable : sortedProducts) {
                writer.write(cookable.toString());
                writer.newLine();
            }
            writer.write("Найденые овощи с калориями от 18 до 23 и весом от 50 до 120 грамм:");
            writer.newLine();
            List<Cookable> filteredProducts = salad.findProducts(18, 23, 50, 120);
            for (Cookable cookable : filteredProducts) {
                writer.write(cookable.toString());
                writer.newLine();
            }
        } catch (InputMismatchException e) {
            System.out.println("Некорректный ввод - ожидается числовое значение");
        } catch (NoSuchElementException e) {
            System.out.println("Пользовательский вход исчерпан");
        } catch (IllegalStateException e) {
            System.out.println("Класс Scanner уже закрыт");
        } catch (NegativeArraySizeException e) {
            System.out.println("Размер массива не должен быть отрицательным");
        } catch (InvalidVegetableAmountException | ProductsNotFoundException | EmptySaladException e) {
            try {
                if (writer != null) {
                    writer.write(e.getMessage());
                }
            } catch (IOException e1) {
                System.out.println("Проблемы с записью в файл");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Проблемы при закрытии файла");
                }
            }
        }
    }

    public static int getRandomWeight(int minimumWeight, int maximumWeight) {
        Random random = new Random();
        return random.nextInt(maximumWeight - minimumWeight) + minimumWeight;
    }
}
