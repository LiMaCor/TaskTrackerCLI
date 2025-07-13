package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    protected static int lastId = 0;
    protected int id;
    protected String description;
    protected Status status;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    protected static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void markToDo() {
        setStatus(Status.TODO);
        setUpdatedAt(LocalDateTime.now());
    }

    public void markInProgress() {
        setStatus(Status.IN_PROGRESS);
        setUpdatedAt(LocalDateTime.now());
    }

    public void markDone() {
        setStatus(Status.DONE);
        setUpdatedAt(LocalDateTime.now());
    }

    public String toJson() {
        return "{\"id\":\"" + id + "\", \"description\":\"" + description.strip() + "\", \"status\":\"" + status.toString() +
                "\", \"createdAt\":\"" + createdAt.format(formatter) + "\", \"updatedAt\":\"" + updatedAt.format(formatter) + "\"}";
    }

    public static Task taskFromJson(String json) {
        json = json.replace("{", "").replace("}", "").replace("\"", "");
        String[] jsonElements = json.split(",");

        int taskId = Integer.parseInt(jsonElements[0].split(":")[1].strip());
        String taskDescription = jsonElements[1].split(":")[1].strip();
        String taskStatus = jsonElements[2].split(":")[1].strip();
        LocalDateTime taskCreatedAt = LocalDateTime.parse(jsonElements[3].split("[a-z]:")[1].strip());
        LocalDateTime taskUpdatedAt = LocalDateTime.parse(jsonElements[4].split("[a-z]:")[1].strip());

        Task task = new Task(taskDescription);
        task.setId(taskId);
        task.setStatus(Status.valueOf(taskStatus.toUpperCase().replace(" ", "_")));
        task.setCreatedAt(taskCreatedAt);
        task.setUpdatedAt(taskUpdatedAt);

        if (task.getId() > Task.lastId) {
            lastId = task.getId();
        }

        return task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
