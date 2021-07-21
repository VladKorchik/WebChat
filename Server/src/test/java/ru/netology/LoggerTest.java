package ru.netology;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoggerTest {

    @Test
    public void logTest() throws IOException {
        String testMessage = "testmessage";
        Logger.getLogger().log(testMessage);
        boolean testResult = false;
        Scanner scanner = new Scanner(new File(Logger.getLogger().getLOG_PATH()));
        while (scanner.hasNextLine()) {
            if (scanner.nextLine().contains(testMessage)) {
                testResult = true;
            }
        }
        Assert.assertTrue(testResult);
    }
}
