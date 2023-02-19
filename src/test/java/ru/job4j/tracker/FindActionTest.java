package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindActionTest {

    @Test
    void whenSearchIsCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindAction findAction = new FindAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + item + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(item.getName());
    }

    @Test
    void whenSearchIsNotCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        FindAction findAction = new FindAction(out);

        Input input = mock(Input.class);

        findAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Find item by id ===" + ln + "Заявка с введенным id: " + 0 + " не найдена." + ln);
        assertThat(tracker.findAll()).isEmpty();
    }
}
