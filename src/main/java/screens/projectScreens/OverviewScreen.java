package screens.projectScreens;

import actions.SwipeActions;
import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import utilities.DateUtil;

import java.text.ParseException;
import java.util.Date;

public class OverviewScreen extends BaseProjectScreen {

    public OverviewScreen() {
        super(By.name("OVERVIEW"), "Overview screen");
    }

    private final ILabel lblAllInsideScrollView = getLabel("project_scroll_view");
    private final ILabel lblFundedDate = getLabel("project_disclaimer_text_view");

    public Date getFundedDate() throws ParseException {
        SwipeActions.verticalUpSwipe(lblAllInsideScrollView);
        AqualityServices.getLogger().info("Get funded date");
        return DateUtil.parseToDate(lblFundedDate.getText());
    }
}
