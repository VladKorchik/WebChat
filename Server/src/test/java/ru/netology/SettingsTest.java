package ru.netology;

import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static ru.netology.Settings.SETTINGS_PATH;

public class SettingsTest {

    @Test
    public void getSettingsTest() throws IOException {
        int portFromTxt = 0;
        int portFromSettingsClass = Settings.getSettings();
        try (BufferedReader reader = new BufferedReader(new FileReader(SETTINGS_PATH))) {
            portFromTxt = Integer.parseInt(reader.readLine());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Assert.assertTrue(portFromTxt == portFromSettingsClass);
    }
}
