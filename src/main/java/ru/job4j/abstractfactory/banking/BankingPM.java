package ru.job4j.abstractfactory.banking;

import ru.job4j.abstractfactory.ProjectManager;

public class BankingPM implements ProjectManager  {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manges banking project...");
    }
}
