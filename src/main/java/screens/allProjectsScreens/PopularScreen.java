package screens.allProjectsScreens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import models.Project;
import org.openqa.selenium.By;
import utilities.StringUtil;

public class PopularScreen extends BaseAllProjectsScreen {

    public PopularScreen(){
        super(By.name("POPULAR"), "Popular screen");
    }

    private final ILabel lblFunded = getLabel("percent");
    private final ILabel lblName = getLabel("name_and_blurb_text_view");
    private final ILabel lblDeadlineCountdownLbl = getLabel("deadline_countdown");

    public Project getProjectInfo (int index){
        swipeToActualProject(index);
        AqualityServices.getLogger().info("Get information about project number: " + index);
        return Project.builder()
                .name(StringUtil.removeBlurb(lblName.getText()))
                .percent(lblFunded.getText())
                .deadlineCountdown(StringUtil.parseToInt(lblDeadlineCountdownLbl.getText()))
                .build();
    }
}
