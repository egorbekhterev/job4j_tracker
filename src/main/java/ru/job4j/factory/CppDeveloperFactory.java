package ru.job4j.factory;

public class CppDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}
