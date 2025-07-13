import java.io.IOException;

import static utils.Functions.*;
import handlers.InputHandler;
import handlers.TaskHandler;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskHandler taskHandler;

        try {

            if (args.length < 1) {
                System.out.println("Usage: TaskTrackerCLI <command> [arguments]");
                return;
            }

            if (!validateInitialFileStructure()) {
                taskHandler = new TaskHandler(createTasksFile());
            } else {
                taskHandler = new TaskHandler(getTaskFilePath());
            }

            InputHandler inputHandler = new InputHandler(args);

            inputHandler.handleOperations(taskHandler);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}