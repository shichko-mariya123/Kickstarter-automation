package screens.allProjectsScreens;

import actions.SwipeActions;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import screens.BaseControlsScreen;

public abstract class BaseAllProjectsScreen extends BaseControlsScreen {

    private final String PROJECT_LOCATOR = "//*[@resource-id = '%s:id/project_card_view_group' and @index = %d]";

    private final int indexOfCurrentProject = 0;
    protected final ILabel lblProjectCardViewGroup = getLabel("project_card_view_group");
    protected final ILabel lblAllInsideScrollView = getLabel("discovery_recycler_view");
    private final IButton btnSearch = getButton("search_button");

    protected BaseAllProjectsScreen(By locator, String name) {
        super(locator, name);
    }

    public ILabel getProjectLbl(int number) {
        return getElementFactory().getLabel(
                MobileBy.xpath(String.format(PROJECT_LOCATOR, PACKAGE, number)),
                "Project: " + number);
    }

    public void swipeToActualProject(int number) {
        try {
            AqualityServices.getLogger().info("Swipe to project number: " +  number);
            while (number > 1) {
                AqualityServices.getTouchActions().swipe(getProjectLbl(indexOfCurrentProject + 1).getElement()
                                .getCenter(),
                        getProjectLbl(indexOfCurrentProject).getElement().getLocation());
                number--;
            }
        } catch (NullPointerException ex) {
            ex.getMessage();
        }
    }

    public void clickOnSearchBtn() {
        SwipeActions.verticalDownSwipe(lblAllInsideScrollView);
        btnSearch.click();
    }

}
