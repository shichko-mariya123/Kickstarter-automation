package testDataUtil;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDataManager {
    public static ISettingsFile getTestData() {
        String envName = (String) AqualityServices.get(ISettingsFile.class).getValue("/testData");
        Path resourcePath = Paths.get("testData", envName, "testData.json");
        return new JsonSettingsFile(resourcePath.toString());
    }
}
