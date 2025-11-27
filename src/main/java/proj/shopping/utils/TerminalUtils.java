package proj.shopping.utils;

import proj.shopping.utils.logs.LogsManager;

import java.io.IOException;

public class TerminalUtils {
    public static void executeTerminalCommand(String... commandParts) throws IOException {
        try {
            Process process = Runtime.getRuntime().exec(commandParts); //allure generate -o reports --single-file --clean
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                LogsManager.error("Command failed with exit code: " + exitCode);
            }
        } catch(IOException | InterruptedException e){
                LogsManager.error("Error executing command: " + String.join(" ", commandParts) + " - " + e.getMessage());
            }
        }

    public static int executeTerminalCommandAndWait(String... command) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        process.getInputStream().transferTo(System.out); // print to console
        return process.waitFor(); // wait for exit
    }
}
