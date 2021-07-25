package automation.cucumber.steps;

import automation.cucumber.background.Background;
import automation.cucumber.context.TestContext;
import automation.page.MainPage;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected TestContext context;

    protected WebDriver driver;
    protected MainPage mainPage;
    protected Background background;

    public BaseSteps() {
        context = TestContext.getInstance();
        driver = context.getDriver();
        mainPage = context.getMainPage();
        background = context.getBackground();
    }

}
