package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public Path getTaskFilePath() {
        Path currentDirectoryAbsPath = Path.of("").toAbsolutePath().getParent();
        Path tasksFilePath = currentDirectoryAbsPath.resolve("tasks.json");

        return tasksFilePath;
    }

    public static Path createTasksFile() throws IOException {
        Path currentPath = Path.of("").toAbsolutePath().getParent();
        Path tasksFile = Files.createFile(currentPath.resolve("tasks.json"));

        return tasksFile;
    }
}
