package automation.page;

import automation.utility.Utility;
import deersheep.automation.pageobject.BasePage;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    protected int defaultWaitTimeoutInSec = 120;

    protected String domain = "";

    public MainPage(WebDriver driver) {

        super(driver);

        switch (Utility.getEnv()) {
            case "UAT":
                url = "https://uat.patentcloud.com/dd/";
                domain = "https://uat.patentcloud.com/";
                break;
            case "SIT":
                url = "https://sit.patentcloud.com/dd/";
                domain = "https://sit.patentcloud.com/";
                break;
            case "Stage":
                url = "https://stage.patentcloud.com/dd/";
                domain = "https://stage.patentcloud.com/";
                break;
            case "Production":
                url = "https://app.patentcloud.com/dd/";
                domain = "https://app.patentcloud.com/";
                break;
            default:
                break;
        }
        
        addElement("ChangeLang", "//*[@class='lang']");
        addElement("EnglishLang", "//*[@class='lang-option' and contains(text(), 'English')]");

    }

    @Override
    public void navigate() {
        super.navigate();
        op.sleep(3000);
        op.clickAndWait(getElement("ChangeLang"), getElement("EnglishLang"));
		op.click(getElement("EnglishLang"));
    }

}
