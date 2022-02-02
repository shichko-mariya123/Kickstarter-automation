import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.allProjectsScreens.AllProjectsMenuItem;
import screens.allProjectsScreens.MagicScreen;
import screens.allProjectsScreens.PopularScreen;
import screens.allProjectsScreens.SearchScreen;
import screens.projectScreens.OverviewScreen;
import testDataUtil.TestDataManager;
import utilities.DateUtil;
import utilities.StringUtil;

import java.text.ParseException;

public class GetFundingAndDaysOfPopularProjectTest extends BaseAndroidTest {

    private static final int ACTUAL_PROJECT_NUMBER = StringUtil.parseToInt(TestDataManager
            .getTestData().getValue("/actualProjectNumber").toString());
    private MagicScreen magicScreen = new MagicScreen();
    private PopularScreen popularScreen = new PopularScreen();
    private SearchScreen searchScreen = new SearchScreen();
    private OverviewScreen overviewScreen = new OverviewScreen();
    private Project project;

    @Test
    public void getFundingAndDaysOfPopularProjectTest() throws ParseException {
        magicScreen.getAllProjectsMainMenu().swipe(AllProjectsMenuItem.POPULAR);
        project = popularScreen.getProjectInfo(ACTUAL_PROJECT_NUMBER);
        popularScreen.clickOnSearchBtn();
        searchScreen.searchProject(project.getName());
        Assert.assertTrue(searchScreen.isProjectDisplayed(project.getName()), "Project should be displayed");
        Assert.assertEquals(project, searchScreen.getProjectInfo(), "Project information should be the same");
        searchScreen.clickOnFeaturedSearchResultProject();
        Assert.assertEquals(project.getDeadlineCountdown(), DateUtil.getNumberOfDaysToPresentDate(overviewScreen
                .getFundedDate()), "The number of days remaining should match the funding date");
    }
}
