package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscAndDescByNameTest {

    @Test
    public void ascByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("Petr"),
                new Item("Ivan"),
                new Item("Sergey")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Ivan"),
                new Item("Petr"),
                new Item("Sergey")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void descByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("Petr"),
                new Item("Ivan"),
                new Item("Sergey")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Sergey"),
                new Item("Petr"),
                new Item("Ivan")
        );
        assertThat(items).isEqualTo(expected);
    }
}
