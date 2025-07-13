package handlers;

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

                }
                case "mark-todo": {

                }
                case "mark-in-progress": {

                }
                case "mark-done": {

                }
                case "list": {

                }
                default: {

                }
            }
        }
    }
}
