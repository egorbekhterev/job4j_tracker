package ru.job4j.tracker;

public class Bus implements Transport {

    @Override
    public void toRide() {
        System.out.println("В путь отправляются: ");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println(quantity + " пассажиров.");
    }

    @Override
    public double toFuelUp(double litres) {
        return 47.25 * litres;
    }
}
