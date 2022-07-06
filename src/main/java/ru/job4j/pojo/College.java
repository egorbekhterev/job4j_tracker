package ru.job4j.pojo;

import java.util.Date;

public class College extends  Student {
    public static void main(String[] args) {
        College student = new College();
        student.setFullName("Bekhterev Egor Vadimovich");
        student.setGroup("EMM-92");
        student.setEntrance(new Date());
        System.out.println(student.getFullName() + System.lineSeparator()
                + student.getGroup() + System.lineSeparator()
                + student.getEntrance());
    }
}
