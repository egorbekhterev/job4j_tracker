package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found in the array.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"Vasya", "Petya", "Ivan"};
        try {
            System.out.println(indexOf(value, "Petya"));
            System.out.println(indexOf(value, "Ivan"));
            System.out.println(indexOf(value, "Borya"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
