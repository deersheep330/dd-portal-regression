package automation.page;

import automation.utility.Utility;
import deersheep.automation.pageobject.BasePage;
import deersheep.automation.utility.PropertiesTool;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    protected int defaultWaitTimeoutInSec = 120;

    protected String domain = "";

    public MainPage(WebDriver driver) {

        super(driver);

        switch (Utility.getEnv()) {
            case "UAT":
                url = "https://uat.patentcloud.com/dd/portal";
                domain = "https://uat.patentcloud.com/";
                break;
            case "SIT":
                url = "https://sit.patentcloud.com/dd/portal";
                domain = "https://sit.patentcloud.com/";
                break;
            case "Stage":
                url = "https://stage.patentcloud.com/dd/portal";
                domain = "https://stage.patentcloud.com/";
                break;
            case "Production":
                url = "https://app.patentcloud.com/dd/portal";
                domain = "https://app.patentcloud.com/";
                break;
            default:
                break;
        }

        // change lang from dd page
        addElement("ChangeLang", "//*[@class='lang']");
        addElement("EnglishLang", "//*[@class='lang-option' and contains(text(), 'English')]");

        // change lang from ps page
        //addElement("ChangeLang2", "//*[contains(@class, 'lang')]//*[contains(@class, 'dropdown-toggle')]");
        //addElement("EnglishLang2", "//*[contains(@class, 'lang')]//*[contains(text(), 'English')]");

        addElement("LoginButton", "(//*[@i18n-txt='login' or @i18n-txt='system.login'])[1]");
        addElement("LoginForm", "//*[@class='login-box']");
        addElement("LoginName", "//input[@id='signName']");
        addElement("LoginPassword", "//input[@id='signPass']");
        addElement("LoginSubmit", "//*[contains(@class, 'modal-body') or contains(@class, 'login-box')]//*[text()='Sign In']");
        addElement("AlreadyLoginIndicator", "//*[@class='user-name-represent']");
        addElement("LogoutSubmit", "//*[contains(@class, 'icon-sign-out')]");

        addElement("DDLogo", "//*[@class='logo__DD']");
        addElement("PortalIndicator", "//*[contains(@i18n-txt, 'dd.portal.left.portal')]");

    }

    @Override
    public void navigate() {
        super.navigate();
        op.sleep(3000);
        op.clickAndWait(getElement("ChangeLang"), getElement("EnglishLang"));
		op.click(getElement("EnglishLang"));
    }

    public void isOnDDPortal() {
        if (op.isExist(getElement("PortalIndicator"))) return;
        else throw new RuntimeException("not on dd portal");
    }

    public void changeLang() {
        op.clickAndWait(getElement("ChangeLang"), getElement("EnglishLang"));
        op.click(getElement("EnglishLang"));
    }

    public void login() {
        String account = PropertiesTool.getProperty("environment", "account");
        String password = PropertiesTool.getProperty("environment", "password");
        if (account.equals("account_email")) throw new RuntimeException("account should be provided");
        if (password.equals("account_password")) throw new RuntimeException("password should be provided");

        login(account, password);
    }

    public void login(String account, String password) {
        if (alreadyLogin()) {
            System.out.println("Already Login!");
            return;
        }

        op.clickAndWait(getElement("LoginButton"), getElement("LoginForm"));
        op.sendText(getElement("LoginName"), account);
        op.sendText(getElement("LoginPassword"), password);
        op.clickAndWait(getElement("LoginSubmit"), getElement("DDLogo"));

        changeLang();
    }

    public void logout() {
        if (alreadyLogin()) {
            op.clickAndWait(getElement("AlreadyLoginIndicator"), getElement("LogoutSubmit"));
            op.click(getElement("LogoutSubmit"));
        }
    }

    public boolean alreadyLogin() {
        if (op.isExist(getElement("AlreadyLoginIndicator"))) return true;
        else return false;
    }

}
