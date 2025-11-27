package proj.shopping.utils;

import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.logs.LogsManager;

import java.io.File;

public class FileUtils {
    private static final String Userdir = PropertyReader.getProperty("user.dir");
    private FileUtils() {

    }

    public static void renameFile(String oldName, String newName) {
        try {
            File oldFile = new File(Userdir + oldName);
            File newFile = new File(Userdir + newName);
            if (oldFile.exists()) {
                if (oldFile.renameTo(newFile)) {
                    LogsManager.info("File renamed from " + oldName + " to " + newName);
                } else {
                    LogsManager.error("Failed to rename file: " + oldName);
                }
            } else {
                LogsManager.warn("File does not exist: " + oldName);
            }
        } catch (Exception e) {
            LogsManager.error("Error renaming file: " + e.getMessage());
        }
    }

    public static void createDirectory(String path) {
        try {
            File file = new File(Userdir + path);
            if (!file.exists())
            {
                file.mkdirs();
                LogsManager.info("Directory created: " + path);
            }


}
        catch (Exception e) {
            LogsManager.error("Error creating directory: " + e.getMessage());
        }
    }

    public static void cleanDirectory(File file){

        try {
            org.apache.commons.io.FileUtils.deleteQuietly(file);
        }
        catch (Exception e) {
            LogsManager.error("Error cleaning directory: " + e.getMessage());
        }
    }
}
