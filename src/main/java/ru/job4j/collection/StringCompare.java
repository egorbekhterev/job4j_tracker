package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int compareLength = Integer.compare(left.length(), right.length());
        int shortestLength = Math.min(left.length(), right.length());
        for (int i = 0; i < shortestLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                compareLength = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return compareLength;
    }
}
