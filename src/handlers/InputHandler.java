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

    public void handleOperations() {
        if (this.inputs.length > 0) {
            String operation = this.inputs[0];

            switch (operation) {
                case "add": {

                }
                case "update": {

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
