package ru.job4j.tracker.store;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HbmTrackerTest {

    @AfterEach
    public void wipeTable() {
        try (var tracker = new HbmTracker()) {
            tracker.findAll().forEach(item -> tracker.delete(item.getId()));
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);

            var result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplaceItemThenTrackerContainsIt() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            tracker.add(item1);

            Item item2 = new Item("replaced item");
            var result = tracker.replace(item1.getId(), item2);

            assertThat(result).isTrue();
            assertThat(tracker.findById(item1.getId()).getName()).isEqualTo(item2.getName());
            assertThat(tracker.findAll()).hasSize(1);
        }
    }

    @Test
    public void whenDeleteItemThenItIsNull() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            int id = item.getId();
            var result = tracker.delete(id);
            assertThat(result).isTrue();
            assertThat(tracker.findById(id)).isNull();
        }
    }

    @Test
    public void whenFindAllThenEmpty() {
        try (var tracker = new HbmTracker()) {
            assertThat(tracker.findAll()).isEmpty();
        }
    }

    @Test
    public void whenFindAllThenGetListOfItems() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item("test1");
            Item item2 = new Item("test2");
            tracker.add(item1);
            tracker.add(item2);
            var result = tracker.findAll();
            assertThat(result).isEqualTo(List.of(item1, item2));
        }
    }

    @Test
    public void whenFindByNameThenGetItemObject() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test");
            tracker.add(item);
            var result = tracker.findByName("test");
            assertThat(result.get(0)).isEqualTo(item);
        }
    }

    @Test
    public void whenFindByIdThenGetItemObject() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test");
            tracker.add(item);
            var result = tracker.findById(item.getId());
            assertThat(result).isEqualTo(item);
        }
    }
}
