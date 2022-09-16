package ru.job4j.abstractfactory.banking;

import ru.job4j.abstractfactory.Developer;
import ru.job4j.abstractfactory.ProjectManager;
import ru.job4j.abstractfactory.ProjectTeamFactory;
import ru.job4j.abstractfactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
