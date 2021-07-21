package ru.netology;

import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SettingsTest {

    @Test
    public void applySettingsTestPort() {
        int testPort = 0;
        Settings.applySettings();
        try (BufferedReader reader = new BufferedReader(new FileReader(Settings.SETTINGS_PATH))) {
            String inputData[] = reader.readLine().split(" ");
            testPort = Integer.parseInt(inputData[0]);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        boolean isPortTheSame = testPort == Settings.usersPort;
        Assert.assertTrue(isPortTheSame);
    }

    @Test
    public void applySettingsTestHost() {
        String testHost = null;
        Settings.applySettings();
        try (BufferedReader reader = new BufferedReader(new FileReader(Settings.SETTINGS_PATH))) {
            String inputData[] = reader.readLine().split(" ");
            testHost = inputData[1];
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        boolean isHostTheSame = testHost.equals(Settings.userHost);
        Assert.assertTrue(isHostTheSame);
    }
}