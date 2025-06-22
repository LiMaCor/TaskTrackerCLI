import java.io.IOException;

import static utils.Functions.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            if (!validateInitialFileStructure()) {
                createTasksFile();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}