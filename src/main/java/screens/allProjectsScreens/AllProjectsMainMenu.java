package screens.allProjectsScreens;

import actions.TouchActions;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import screens.BaseControlsScreen;


public class AllProjectsMainMenu extends BaseControlsScreen {

    protected final ILabel lblProjectCardViewGroup = getLabel("project_card_view_group",
            "Project card view group");
    private final String menuItemLocator = "//*[text() = '%s' and @selected = 'true']";
    private static AllProjectsMenuItem startMenuItem = AllProjectsMenuItem.MAGIC;

    protected AllProjectsMainMenu() {
        super(By.name("All Projects"), "All projects main menu");
    }

    public void swipe(AllProjectsMenuItem endMenuItem) {
        AqualityServices.getLogger().info("Swipe to " + endMenuItem.getName());
        AqualityServices.getConditionalWait().waitFor(() -> {
            if (startMenuItem.ordinal() < endMenuItem.ordinal()) {
                TouchActions.swipe(lblProjectCardViewGroup, SwipeDirection.LEFT);
            } else if (startMenuItem.ordinal() > endMenuItem.ordinal()) {
                TouchActions.swipe(lblProjectCardViewGroup, SwipeDirection.RIGHT);
            }

            return isMenuItemSelected(endMenuItem);
        });
        startMenuItem = endMenuItem;
    }

    private boolean isMenuItemSelected(AllProjectsMenuItem menuItem) {
        String name = menuItem.getName();
        return getElementFactory()
                .getLink(By.xpath(String.format(menuItemLocator, name)), name + " menu item")
                .state().isDisplayed();
    }
}
