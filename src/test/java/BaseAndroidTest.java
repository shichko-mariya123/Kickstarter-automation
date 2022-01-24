import aquality.appium.mobile.application.AqualityServices;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseAndroidTest {

    @BeforeMethod
    void setUp() {
        AqualityServices.getApplication();
    }

    @AfterMethod
    void tearDown() {
        if (AqualityServices.isApplicationStarted()) {
            AqualityServices.getApplication().quit();
        }
    }
}
