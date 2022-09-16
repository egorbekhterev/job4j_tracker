package ru.job4j.abstractfactory.banking;

import ru.job4j.abstractfactory.Developer;

public class JavaDeveloper implements Developer  {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}
