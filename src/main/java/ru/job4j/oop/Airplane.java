package ru.job4j.oop;

public class Airplane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void speed() {
        System.out.println("Скорость составляет: 900 км/ч.");
    }
}
