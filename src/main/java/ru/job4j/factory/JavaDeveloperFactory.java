package ru.job4j.factory;

public class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}
