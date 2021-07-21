package ru.netology;

import java.io.*;

// При первом запуске программы будет создан файл с дефолтным портом.
// Если файл с настройками не существует, то мы создаём его и записываем в него
//   дефолтный порт. Если существует - считываем порт из него.
// В дальнейшем, если изменить порт вручную в  файле settings.txt, будет использоваться
//  тот порт, который установил пользователь.

public class Settings {
    static String systemUserName = System.getProperty("user.name");
    static final String MAIN_DIR = "C:\\Users\\" + systemUserName + "\\Documents\\Online chat server";
    static final int DEFAULT_PORT = 9999;
    public static int usersPort;
    static final String SETTINGS_PATH = MAIN_DIR + "//Settings.txt";
    static final boolean APP_END_SETTINGS = false;

    public static int getSettings() {
        File settings = new File(SETTINGS_PATH);
        if (!settings.exists()) {
            try {
                createDir();
                settings.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            try (FileWriter fileWriter = new FileWriter(SETTINGS_PATH, APP_END_SETTINGS)) {
                fileWriter.write(Integer.toString(DEFAULT_PORT));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            usersPort = DEFAULT_PORT;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(SETTINGS_PATH))) {
                usersPort = Integer.parseInt(reader.readLine());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return usersPort;
    }

    public static void createDir() throws IOException {
        File dir = new File(MAIN_DIR);
        if (dir.mkdir()) {
            String message = "Создана системная папка " + MAIN_DIR;
            Logger.getLogger().log(message);
        }
    }
}
