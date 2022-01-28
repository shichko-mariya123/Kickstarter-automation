package configuration;

import aquality.appium.mobile.application.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigDataManager {
    public static ISettingsFile getConfigData() {
        String envName = (String) AqualityServices.get(ISettingsFile.class).getValue("/environment");
        Path resourcePath = Paths.get("environment", envName, "config.json");
        return new JsonSettingsFile(resourcePath.toString());
    }
}
