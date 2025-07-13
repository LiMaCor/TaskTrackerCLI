package handlers;

import model.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskHandler {
    protected final Path FILE_PATH;
    protected List<Task> tasks;

    public TaskHandler(Path pathToTaskFile) {
        this.FILE_PATH = pathToTaskFile;
        this.tasks = loadTasksFromFile();
    }

    public void saveTasksToFile() {
        StringBuilder sb = new StringBuilder();

        sb.append("[\n");

        for (int i = 0; i < tasks.size(); i++) {
            sb.append(tasks.get(i).toJson());

            if (i < tasks.size() - 1) {
                sb.append(",\n");
            }
        }

        sb.append("\n]");

        String jsonContent = sb.toString();

        try {
            Files.writeString(this.FILE_PATH, jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> loadTasksFromFile() {
        List<Task> loadedTasks = new ArrayList<>();

        try {
            String jsonContent = Files.readString(this.FILE_PATH);

            if (jsonContent.isEmpty()) {
                return new ArrayList<>();
            }

            String[] taskList = jsonContent.replace("[", "")
                    .replace("]", "")
                    .split("},");

            for (String taskJson : taskList) {
                if (!taskJson.endsWith("}")) {
                    taskJson = taskJson + "}";
                    loadedTasks.add(Task.taskFromJson(taskJson));
                } else {
                    loadedTasks.add(Task.taskFromJson(taskJson));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedTasks;
    }

    public Optional<Task> getTask(String id) {
        return this.tasks.stream().filter((task) -> task.getId() == Integer.parseInt(id)).findFirst();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);

        this.tasks.add(newTask);

        System.out.println("Task with id " + newTask.getId() + " has been successfully added.");
    }

    public void updateTask(String id, String updatedDescription) {
        Task task = getTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.setDescription(updatedDescription);
    }

    public void deleteTask(String id) {
        Task task = getTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        this.tasks.remove(task);
    }

    public void markToDo(String id) {
        Task task = getTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.markToDo();
    }

    public void markInProgress(String id) {
        Task task = getTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.markInProgress();
    }

    public void markDone(String id) {
        Task task = getTask(id).orElseThrow(() -> new IllegalArgumentException("Task with id " + id + " not found."));
        task.markToDo();
    }
}
