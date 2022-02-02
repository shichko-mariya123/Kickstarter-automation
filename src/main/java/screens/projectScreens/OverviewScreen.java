package screens.projectScreens;

import actions.TouchActions;
import aquality.appium.mobile.actions.SwipeDirection;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;
import screens.BaseControlsScreen;
import utilities.DateUtil;

import java.text.ParseException;
import java.util.Date;

public class OverviewScreen extends BaseControlsScreen {

    public OverviewScreen() {
        super(By.name("OVERVIEW"), "Overview screen");
    }

    private final ILabel lblAllInsideScrollView = getLabel("project_scroll_view",
            "All inside scroll view");
    private final ILabel lblFundedDate = getLabel("project_disclaimer_text_view", "Funded label");

    public Date getFundedDate() throws ParseException {
        TouchActions.swipe(lblAllInsideScrollView, SwipeDirection.UP);
        AqualityServices.getLogger().info("Get funded date");
        return DateUtil.parseToDate(lblFundedDate.getText());
    }
}
