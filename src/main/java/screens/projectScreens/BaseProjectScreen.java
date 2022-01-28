package screens.projectScreens;

import org.openqa.selenium.By;
import screens.BaseControlsScreen;

public abstract class BaseProjectScreen extends BaseControlsScreen {

    protected BaseProjectScreen(By locator, String name) {
        super(locator, name);
    }

}
