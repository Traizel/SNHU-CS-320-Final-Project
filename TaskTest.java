import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("123", "Test Task", "Task description");

        assertEquals("123", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("Task description", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Desc"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Desc"));
    }

    @Test
    public void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Desc"));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("123", "ThisNameIsWayTooLongForTheLimit", "Desc"));
    }

    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Name", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Task("123", "Name", "This description is definitely longer than fifty characters total."));
    }

    @Test
    public void testSettersUpdateFields() {
        Task task = new Task("123", "Name", "Desc");

        task.setName("New Name");
        task.setDescription("New Description");

        assertEquals("New Name", task.getName());
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testSettersRejectInvalidValues() {
        Task task = new Task("123", "Name", "Desc");

        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class,
                () -> task.setDescription("This description is definitely longer than fifty characters total."));
    }
}
