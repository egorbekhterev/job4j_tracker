package ru.job4j.abstractfactory.banking;

import ru.job4j.abstractfactory.Tester;

public class QATester implements Tester {
    @Override
    public void testCode() {
        System.out.println("QA tester tests banking code...");
    }
}
