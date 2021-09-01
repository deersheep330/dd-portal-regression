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

        addElement("ChangeLang", "//*[@class='lang']");
        addElement("EnglishLang", "//*[@class='lang-option' and contains(text(), 'English')]");

        addElement("LoginButton", "(//*[@i18n-txt='login' or @vue-i18n-txt='login' or @i18n-txt='system.login' or @vue-i18n-txt='system.login'])[1]");
        addElement("LoginForm", "//*[contains(@class, 'login-box')]");
        addElement("LoginName", "//input[@id='signName']");
        addElement("LoginPassword", "//input[@id='signPass']");
        addElement("LoginSubmit", "//*[contains(@class, 'modal-body') or contains(@class, 'login-box')]//*[text()='Sign In']");
        addElement("AlreadyLoginIndicator", "//*[@class='user-name-represent']");
        addElement("LogoutSubmit", "//*[contains(@class, 'icon-sign-out')]");

        addElement("DDLogo", "//*[@class='logo__DD']");
        addElement("PortalIndicator", "//*[contains(@i18n-txt, 'dd.portal.left.portal')]");

        addElement("MainCategory", "//*[contains(@i18n-txt, 'dd.portal.industryame')]");
        addElement("SubCategory", "//*[contains(@i18n-txt, 'dd.portal.industrytype.')]");

        addElement("UltimateParent", "//*[contains(@class, 'collapse') and contains(@class, 'show')]//*[contains(@class, 'ultimateParent')]");
        addElement("CompanyList", "//*[contains(@class, 'portalCompanyList__column--rank')]/label[contains(text(), '.')]");
        addElement("CollapseButton", "//*[contains(@class, 'portalCompanyList__column--collapseIcon')]//span[not(contains(@style, 'none'))]//*[name()='svg']");

        addElement("RankingSelect", "//*[contains(@class, 'portalSelector')]//select");
        // value = categoryPatentCount
        // value = activePatentCount
        // value = highValuePatentCount
        // value = recentlyAppliedPatentCount

        addElement("RankingNumbers", "//*[contains(@class, 'portalCompanyList__body--dynamic')]/div/*[contains(@class, 'portalCompanyList__row')]//*[contains(@class, 'portalCompanyList__column')][1]");

        addElement("FilterButton", "//*[contains(@class, 'portalFilterButton')]//*[contains(@i18n-txt, 'due.chartcommon.filter')]");
        addElement("ParentCompany", "//form//label[contains(text(), 'Parent company')]");
        addElement("Subsidiary", "//form//label[contains(text(), 'Subsidiary')]");
        addElement("IndependentCompany", "//form//label[contains(text(), 'Independent company')]");
        addElement("SEPOwner", "//form//label[contains(text(), 'SEP Owner')]");
        addElement("3GPPMember", "//form//label[contains(text(), '3GPP Member')]");
        addElement("LargerThanZero", "//form//label[contains(text(), '>0%')]");
        addElement("LargerThanTwentyFive", "//form//label[contains(text(), '>25%')]");
        addElement("ClearPercentage", "//form//span[contains(@i18n-txt, 'due.chart.clear') and not(contains(@style, 'none'))]");
        addElement("FilterSubmit", "//*[contains(@i18n-txt, 'due.button.submit') and contains(@class, 'portalFilterButton')]");

        addElement("CompanyTabShow", "//*[@id='accordion-1-detail-table' and not(contains(@style, 'none'))]");
        addElement("SampleReportTabShow", "//*[@id='accordion-2-detail-table' and not(contains(@style, 'none'))]");
        addElement("CompanyTabToggle", "(//*[contains(@class, 'portalCompanyCollapaseBlock__header__title')])[1]");
        addElement("SampleReportTabToggle", "(//*[contains(@class, 'portalCompanyCollapaseBlock__header__title')])[2]");

        addElement("ViewReport", "//*[contains(text(), 'View Report')]");

        addElement("Categories", "//*[contains(@class, 'portalCompanyDetailTable__button')]");

        addElement("MainLabelNumbers", "//*[contains(@class, 'portalNumberLabel__number')]");
        addElement("SubLabelNumbers", "//*[contains(@class, 'portalDescription__number')]");
        addElement("FieldLabelNumbers", "//*[contains(@class, 'portalTechField__number')]");

        addElement("SampleReports", "//*[contains(@class, 'portalSampleReport__link')]");

        addElement("SearchInput", "//*[contains(@class, 'companySearch__input')]");
        addElement("SearchSubmit", "//*[contains(@class, 'companySearch__icon')]//*[name()='svg' and contains(@class, 'fa-search')]");
        addElement("GoToPartySearch", "//*[contains(@i18n-txt, 'dd.portal.button.patentsearch')]");
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
