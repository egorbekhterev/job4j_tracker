package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSplitted = left.split("\\.");
        String[] rightSplitted = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftSplitted[0]), Integer.parseInt(rightSplitted[0]));
    }
}
