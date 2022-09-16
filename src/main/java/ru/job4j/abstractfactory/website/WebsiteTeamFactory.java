package ru.job4j.abstractfactory.website;

import ru.job4j.abstractfactory.Developer;
import ru.job4j.abstractfactory.ProjectManager;
import ru.job4j.abstractfactory.ProjectTeamFactory;
import ru.job4j.abstractfactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}
