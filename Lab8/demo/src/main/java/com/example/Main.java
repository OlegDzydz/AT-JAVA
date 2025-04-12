package com.example;

public class Main {

    // Повертає довжину вхідного рядка.
    public int getLength(String input) {
        return input.length();
    }

    // Повертає підрядок, починаючи з індексу 'start' (включно) до 'end'
    // (невключно).
    public String getSubstring(String input, int start, int end) {
        return input.substring(start, end);
    }

    // Повертає індекс першої появи підрядка 'search' у рядку.
    public int findIndex(String input, String search) {
        return input.indexOf(search);
    }

    // Головний метод для демонстрації роботи методів.
    public static void main(String[] args) {
        Main mainInstance = new Main();
        String message = "Hello, Java World!";
        System.out.println("Довжина рядка: " + mainInstance.getLength(message));
        System.out.println("Підрядок (7, 11): " + mainInstance.getSubstring(message, 7, 11));
        System.out.println("Індекс 'Java': " + mainInstance.findIndex(message, "Java"));
    }
}
