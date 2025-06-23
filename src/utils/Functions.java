package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Functions {

    public static boolean validateInitialFileStructure() {
        Path currentDirectoryAbsPath = Path.of("").toAbsolutePath().getParent();
        Path tasksFilePath = currentDirectoryAbsPath.resolve("tasks.json");

        if (Files.exists(tasksFilePath)) {
            return true;
        } else {
            return false;
        }
    }

    public static Path createTasksFile() throws IOException {
        Path currentPath = Path.of("").toAbsolutePath().getParent();
        Path tasksFile = Files.createFile(currentPath.resolve("tasks.json"));

        return tasksFile;
    }
}
