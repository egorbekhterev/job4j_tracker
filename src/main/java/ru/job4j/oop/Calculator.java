package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumOfAllOperations(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);
        int resultSum = Calculator.sum(10);
        System.out.println(resultSum);
        int resultMinus = calculator.minus(10);
        System.out.println(resultMinus);
        int resultDivide = calculator.divide(10);
        System.out.println(resultDivide);
        int resultTotal = calculator.sumOfAllOperations(10);
        System.out.println(resultTotal);
    }
}
