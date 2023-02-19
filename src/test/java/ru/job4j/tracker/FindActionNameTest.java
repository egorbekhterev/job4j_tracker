package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindActionNameTest {

    @Test
    void whenSearchByNameIsCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindActionName findActionName = new FindActionName(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(item.getName());

        findActionName.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln + item + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(item.getName());
    }

    @Test
    void whenSearchByNameIsNotCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        FindActionName findActionName = new FindActionName(out);

        Input input = mock(Input.class);

        findActionName.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find items by name ===" + ln + "Заявки с именем: null не найдены." + ln);
        assertThat(tracker.findAll()).isEmpty();
    }
}