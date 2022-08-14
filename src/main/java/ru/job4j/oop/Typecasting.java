package ru.job4j.oop;

public class Typecasting {
    public static void main(String[] args) {
        Vehicle plane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] vehicles = new Vehicle[]{plane, bus, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.speed();
            System.out.println(System.lineSeparator());
        }
    }
}
