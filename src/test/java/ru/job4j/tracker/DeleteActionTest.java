package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    void whenRemovalIsCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String removed = "Removed item";
        tracker.add(new Item(removed));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(removed);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ===" + ln + "Заявка удалена успешно." + ln);
        assertThat(tracker.findAll()).isEmpty();
    }

    @Test
    void whenRemovalIsNotCompleted() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String removed = "Removed item";
        tracker.add(new Item(removed));
        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo("=== Delete item ===" + ln + "Заявка с id = 0 не найдена." + ln);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(removed);
    }
}
