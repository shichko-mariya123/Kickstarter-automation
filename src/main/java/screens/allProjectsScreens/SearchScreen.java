package screens.allProjectsScreens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.ElementType;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import models.Project;
import org.openqa.selenium.By;
import utilities.StringUtil;

public class SearchScreen extends BaseAllProjectsScreen{

    public SearchScreen() {
        super(By.name("Search"), "Search screen");
    }

    private final String nameOfSearchResult = "//*[contains (@text, '%s')]";
    private final ITextBox txbSearch = getTextBox("search_edit_text");
    private final ILabel lblFeaturedSearchResult = getLabel("featured_search_result_view");
    private final ILabel lblFunded = getLabel("search_result_percent_funded_text_view");
    private final ILabel lblName = getLabel("project_name_text_view");
    private final ILabel lblDeadlineCountdownLbl = getLabel("search_result_deadline_countdown_text_view");

    public void searchProject (String projectName){
        txbSearch.clearAndType(projectName);
    }

    public boolean isProjectDisplayed(String projectName){
       return lblFeaturedSearchResult.findChildElement(By
               .xpath(String.format(nameOfSearchResult, projectName)),
               ElementType.LABEL).state().isDisplayed();
    }

    public Project getProjectInfo(){
        AqualityServices.getLogger().info("Get information about featured search result");
        return Project.builder()
                .name(lblName.getText())
                .deadlineCountdown(StringUtil.parseToInt(lblDeadlineCountdownLbl.getText()))
                .percent(lblFunded.getText())
                .build();
    }

    public void clickOnFeaturedSearchResultProject(){
        AqualityServices.getLogger().info("Open project from featured search result");
        lblFeaturedSearchResult.click();
    }
}
