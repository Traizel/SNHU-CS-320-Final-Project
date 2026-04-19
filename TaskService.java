import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }

        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID was not found.");
        }

        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String name) {
        Task task = getExistingTask(taskId);
        task.setName(name);
    }

    public void updateTaskDescription(String taskId, String description) {
        Task task = getExistingTask(taskId);
        task.setDescription(description);
    }

    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    private Task getExistingTask(String taskId) {
        if (taskId == null || !tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID was not found.");
        }

        return tasks.get(taskId);
    }
}
