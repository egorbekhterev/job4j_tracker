package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
        System.out.println(System.lineSeparator());
        airbus.setName(null);
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
    }
}
