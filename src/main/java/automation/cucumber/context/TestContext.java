package automation.cucumber.context;

import automation.cucumber.background.Background;
import automation.page.MainPage;
import org.openqa.selenium.WebDriver;

public class TestContext {

    private static TestContext instance = null;

    private String buildNum;
    private WebDriver driver;
    private MainPage mainPage;
    private EmailPage emailPage;
    private Background background;

    private TestContext() {

    }

    public static TestContext getInstance() {
        if (instance == null) instance = new TestContext();
        return instance;
    }

    public String getBuildNum() { return buildNum; }
    public WebDriver getDriver() { return driver; }
    public MainPage getMainPage() { return mainPage; }
    public Background getBackground() { return background; }
    public EmailPage getEmailPage() { return emailPage; }

    public void setBuildNum(String buildNum) { this.buildNum = buildNum; }
    public void setDriver(WebDriver driver) { this.driver = driver; }
    public void setMainPage(MainPage mainPage) { this.mainPage = mainPage; }
    public void setBackground(Background background) { this.background = background; }
    public void setEmailPage(EmailPage emailPage) { this.emailPage = emailPage; }

}
