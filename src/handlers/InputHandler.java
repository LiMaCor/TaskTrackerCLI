package handlers;

import model.Status;

public class InputHandler {
    protected String[] inputs;

    public InputHandler(String[] inputs) {
        this.inputs = inputs;
    }

    public String[] getInputs() {
        return this.inputs;
    }

    public void setInputs(String[] inputs) {
        this.inputs = inputs;
    }

    public void handleOperations(TaskHandler taskHandler) {
        if (this.inputs.length > 0) {
            String operation = this.inputs[0];

            switch (operation) {
                case "add": {
                    if (inputs.length < 2) {
                        System.out.println("Usage: TaskTrackerCLI add <description>");
                        return;
                    }

                    taskHandler.addTask(inputs[1]);
                    break;
                }
                case "update": {
                    if (inputs.length < 3) {
                        System.out.println("Usage: TaskTrackerCLI update <id> <new description>");
                        return;
                    }

                    taskHandler.updateTask(inputs[1], inputs[2]);
                    break;
                }
                case "delete": {
                    if (inputs.length < 2) {
                        System.out.println("Usage: TaskTrackerCLI delete <id>");
                        return;
                    }

                    taskHandler.deleteTask(inputs[1]);
                    break;
                }
                case "mark-todo": {
                    if (inputs.length < 2) {
                        System.out.println("Usage: TaskTrackerCLI mark-todo <id>");
                        return;
                    }

                    taskHandler.markToDo(inputs[1]);
                    break;
                }
                case "mark-in-progress": {
                    if (inputs.length < 2) {
                        System.out.println("Usage: TaskTrackerCLI mark-in-progress <id>");
                        return;
                    }

                    taskHandler.markInProgress(inputs[1]);
                    break;
                }
                case "mark-done": {
                    if (inputs.length < 2) {
                        System.out.println("Usage: TaskTrackerCLI mark-done <id>");
                        return;
                    }

                    taskHandler.markDone(inputs[1]);
                    break;
                }
                case "list": {
                    if (inputs.length < 2) {
                        System.out.println("Usage: TaskTrackerCLI list <status>. Available status: todo, in-progress, done");

                        taskHandler.listTasks("All");
                    } else {
                        Status inputStatus;
                        try {
                            inputStatus = Status.valueOf(inputs[1].toUpperCase().replace("-", "_"));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid status: " + inputs[1]);
                            break;
                        }

                        taskHandler.listTasks(inputStatus.toString());
                    }
                }
                default: {
                    System.out.println(operation + " is not a valid operation.");
                    break;
                }
            }

            taskHandler.saveTasksToFile();
        }
    }
}
