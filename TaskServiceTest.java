import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task", "Desc");

        service.addTask(task);

        assertEquals(task, service.getTask("1"));
    }

    @Test
    public void testAddDuplicateTaskFails() {
        TaskService service = new TaskService();
        Task first = new Task("1", "Task", "Desc");
        Task second = new Task("1", "Other", "Another description");

        service.addTask(first);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(second));
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task", "Desc");

        service.addTask(task);
        service.deleteTask("1");

        assertNull(service.getTask("1"));
    }

    @Test
    public void testDeleteMissingTaskFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("999"));
    }

    @Test
    public void testUpdateTaskFields() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task", "Desc");

        service.addTask(task);
        service.updateTaskName("1", "Updated");
        service.updateTaskDescription("1", "Updated Desc");

        assertEquals("Updated", service.getTask("1").getName());
        assertEquals("Updated Desc", service.getTask("1").getDescription());
    }

    @Test
    public void testUpdateMissingTaskFails() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("999", "Nope"));
    }

    @Test
    public void testUpdateRejectsInvalidValues() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task", "Desc");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("1", null));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateTaskDescription("1", "This description is definitely longer than fifty characters total."));
    }
}
