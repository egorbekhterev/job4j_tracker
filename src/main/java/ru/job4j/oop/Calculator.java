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
        int total = sum(y) + minus(y) + divide(y) + multiply(y);
        return total;
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println(resultSum);
        Calculator calculatorMinus = new Calculator();
        int resultMinus = calculatorMinus.minus(10);
        System.out.println(resultMinus);
        Calculator calculatorDivide = new Calculator();
        int resultDivide = calculatorDivide.divide(10);
        System.out.println(resultDivide);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(10);
        System.out.println(rsl);
        Calculator calculatorTotal = new Calculator();
        int resultTotal = calculatorTotal.sumOfAllOperations(10);
        System.out.println(resultTotal);
    }
}
