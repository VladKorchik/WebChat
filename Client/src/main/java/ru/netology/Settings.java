package ru.netology;

import java.io.*;

public class Settings {
    static String systemUserName = System.getProperty("user.name");
    static final String MAIN_DIR = "C:\\Users\\" + systemUserName + "\\Documents\\Online chat";
    static final int DEFAULT_PORT = 9999;
    public static int usersPort;
    public static final String DEFAULT_HOST = "127.0.0.1";
    public static String userHost;
    static final String SETTINGS_PATH = MAIN_DIR + "//Settings.txt";
    static final boolean APP_END_SETTINGS = false;

    public static void applySettings() {
        File settings = new File(SETTINGS_PATH);
        if (!settings.exists()) {
            try {
                createDir();
                settings.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter(SETTINGS_PATH, APP_END_SETTINGS)) {
                fileWriter.write(Integer.toString(DEFAULT_PORT) + " " + DEFAULT_HOST);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            usersPort = DEFAULT_PORT;
            userHost = DEFAULT_HOST;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(SETTINGS_PATH))) {
                //usersPort = Integer.parseInt(reader.readLine());
                String inputData[] = reader.readLine().split(" ");
                usersPort = Integer.parseInt(inputData[0]);
                userHost = inputData[1];
                } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void createDir() throws IOException {
        File dir = new File(MAIN_DIR);
        if (dir.mkdir()) {
            String message = "Создана системная папка " + MAIN_DIR;
            System.out.println(message);
            Logger.getLogger().log(message);
        }
    }
}
