package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам.");
    }

    @Override
    public void speed() {
        System.out.println("Скорость составляет: 100 км/ч.");
    }
}
