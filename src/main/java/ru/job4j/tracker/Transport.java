package ru.job4j.tracker;

public interface Transport {
    void toRide();

    void passengers(int quantity);

    double toFuelUp(double litres);
}
