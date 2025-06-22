import java.io.IOException;

import static utils.Functions.*;
import handlers.InputHandler;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            if (!validateInitialFileStructure()) {
                createTasksFile();
            }

            InputHandler inputHandler = new InputHandler(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}