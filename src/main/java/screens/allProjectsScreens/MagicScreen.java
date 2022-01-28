package screens.allProjectsScreens;

import actions.SwipeActions;
import aquality.appium.mobile.application.AqualityServices;
import org.openqa.selenium.By;

public class MagicScreen extends BaseAllProjectsScreen {

    public MagicScreen() {
        super(By.name("MAGIC"), "Magic screen");
    }

    public void swipeToPopular(){
        AqualityServices.getLogger().info("Go to 'Popular screen'");
        SwipeActions.horizontalRightSwipe(lblProjectCardViewGroup);
    }
}
