package automation.cucumber.runner;

import automation.cucumber.background.Background;
import automation.cucumber.context.TestContext;
import automation.page.MainPage;
import automation.pagefactory.MainPageFactory;
import automation.preprocess.Preprocess;
import deersheep.automation.utility.PropertiesTool;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/features/PortalTest",
        plugin={"pretty",
                "html:build/test-results/cucumber/PortalTest",
                "junit:build/test-results/junit/regression.PortalTest.xml"},
        glue={"automation.cucumber.steps.main"},
        monochrome=true,
        strict=true)
public class PortalTestRunner {

    @BeforeClass
    public static void setUp() {

        System.out.println("===> BeforeClass setUp");

        String buildNum = PropertiesTool.getProperty("buildNum", "build");
        WebDriver driver = Preprocess.setupWebDriverWrapper();
        MainPage mainPage = MainPageFactory.getMainPage(driver);
        Background background = new Background() {
            @Override
            public boolean isMet() {
                return false;
            }
        };

        TestContext context = TestContext.getInstance();

        context.setBuildNum(buildNum);
        context.setDriver(driver);
        context.setMainPage(mainPage);
        context.setBackground(background);
    }

    @AfterClass
    public static void tearDown() {
        if (TestContext.getInstance().getMainPage() != null) {
            TestContext.getInstance().getMainPage().logout();
            TestContext.getInstance().getDriver().quit();
        }

        System.out.println("===> AfterClass tearDown");
    }

}
