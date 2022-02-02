package screens.allProjectsScreens;

import actions.TouchActions;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import screens.BaseControlsScreen;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAllProjectsScreen extends BaseControlsScreen {

    private final String PROJECT_LOCATOR = "//*[@resource-id = '%s:id/project_card_view_group' and @index = %d]";

    private final int indexOfCurrentProject = 0;
    protected final ILabel lblAllInsideScrollView = getLabel("discovery_recycler_view");
    protected final ILabel lblProjectName = getLabel("name_and_blurb_text_view");
    private final IButton btnSearch = getButton("search_button");
    private AllProjectsMainMenu allProjectsMainMenu = new AllProjectsMainMenu();
    private List projects = new ArrayList<>();

    protected BaseAllProjectsScreen(By locator, String name) {
        super(locator, name);
    }

    public ILabel getProjectLbl(int number) {
        return getElementFactory().getLabel(
                MobileBy.xpath(String.format(PROJECT_LOCATOR, PACKAGE, number)),
                "Project: " + number);
    }

    public void swipeToActualProject(int number) {
        AqualityServices.getLogger().info("Swipe to project number: " + number);
        AqualityServices.getConditionalWait().waitFor(() -> {
            projects.add(lblProjectName.getText());
            AqualityServices.getTouchActions().swipe(getProjectLbl(indexOfCurrentProject + 1).getElement()
                            .getCenter(),
                    getProjectLbl(indexOfCurrentProject).getElement().getLocation());
        return projects.stream().distinct().count() == number - 1; });
    }

    public void clickOnSearchBtn() {
        TouchActions.swipe(lblAllInsideScrollView, SwipeDirection.DOWN);
        btnSearch.click();
    }

    public AllProjectsMainMenu getAllProjectsMainMenu() {
        return allProjectsMainMenu;
    }
}
