package automation.page;

import automation.utility.Utility;
import deersheep.automation.pageobject.BasePage;
import deersheep.automation.utility.NumberTool;
import deersheep.automation.utility.PropertiesTool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MainPage extends BasePage {

    protected int defaultWaitTimeoutInSec = 120;

    protected String domain = "";

    protected int numberOfCompanies = -1;

    protected int numberOfPatents = -1;
    protected List<Integer> patentAssetsSummaryNumbers;
    protected List<Integer> techAndPatentSummaryNumbers;

    protected List<Integer> numberOfValidPatents;
    protected List<Integer> numberOfHighValuePatents;
    protected List<Integer> mainTechFieldNumbers;

    public MainPage(WebDriver driver) {

        super(driver);

        switch (Utility.getEnv()) {
            case "UAT":
                url = "https://uat.patentcloud.com/dd/portal";
                domain = "https://uat.patentcloud.com";
                break;
            case "SIT":
                url = "https://sit.patentcloud.com/dd/portal";
                domain = "https://sit.patentcloud.com";
                break;
            case "Stage":
                url = "https://stage.patentcloud.com/dd/portal";
                domain = "https://stage.patentcloud.com";
                break;
            case "Production":
                url = "https://app.patentcloud.com/dd/portal";
                domain = "https://app.patentcloud.com";
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
        addElement("UnexpandedCollapseButton", "//*[contains(@class, 'portalCompanyList__column--collapseIcon')]//span[not(contains(@style, 'none'))]//*[name()='svg' and contains(@class, 'down')]");
        addElement("ExpandedCollapseButton", "//*[contains(@class, 'portalCompanyList__column--collapseIcon')]//span[not(contains(@style, 'none'))]//*[name()='svg' and contains(@class, 'up')]");

        addElement("RankingSelect", "//*[contains(@class, 'portalSelector')]//select");
        // value = categoryPatentCount
        // value = activePatentCount
        // value = highValuePatentCount
        // value = recentlyAppliedPatentCount

        addElement("RankingNumbers", "//*[contains(@class, 'portalCompanyList__body--dynamic')]/div/*[contains(@class, 'portalCompanyList__row')]//*[contains(@class, 'portalCompanyList__column')][1]//label");

        addElement("FilterButton", "//*[contains(@class, 'portalFilterButton')]//*[contains(@i18n-txt, 'due.chartcommon.filter')]");
        addElement("ParentCompany", "//div[contains(@class, 'show')]//form//label[contains(text(), 'Parent company')]");
        addElement("Subsidiary", "//div[contains(@class, 'show')]//form//label[contains(text(), 'Subsidiary')]");
        addElement("IndependentCompany", "//div[contains(@class, 'show')]//form//label[contains(text(), 'Independent company')]");
        addElement("SEPOwner", "//div[contains(@class, 'show')]//form//label[contains(text(), 'SEP Owner')]");
        addElement("3GPPMember", "//div[contains(@class, 'show')]//form//label[contains(text(), '3GPP Member')]");
        addElement("LargerThanZero", "//div[contains(@class, 'show')]//form//label[contains(text(), '>0%')]");
        addElement("LargerThanTwentyFive", "//div[contains(@class, 'show')]//form//label[contains(text(), '>25%')]");
        addElement("ClearPercentage", "//div[contains(@class, 'show')]//form//span[contains(@i18n-txt, 'due.chart.clear') and not(contains(@style, 'none'))]");
        addElement("FilterSubmit", "//*[contains(@i18n-txt, 'due.button.submit') and contains(@class, 'portalFilterButton')]");

        addElement("CompanyTabShow", "//*[@id='accordion-1-detail-table' and not(contains(@style, 'none'))]");
        addElement("SampleReportTabShow", "//*[@id='accordion-2-detail-table' and not(contains(@style, 'none'))]");
        addElement("CompanyTabToggle", "(//*[contains(@class, 'portalCompanyCollapaseBlock__header__title')])[1]");
        addElement("SampleReportTabToggle", "(//*[contains(@class, 'portalCompanyCollapaseBlock__header__title')])[2]");

        addElement("ViewReport", "//*[contains(text(), 'View Report')]");
        addElement("NumberOfPatents", "(//*[contains(@class, 'portalNumberLabel__number')])[1]");
        addElement("AllFields", "//*[contains(@class, 'portalCompanyDetailTable') and contains(text(), 'All fields')]");

        addElement("NumberOfValidPatents", "(//*[contains(@class, 'portalDescription__number')])[1]");
        addElement("NumberOfHighValuePatents", "(//*[contains(@class, 'portalDescription__number')])[2]");
        addElement("MainTechFieldNumbers", "(//*[contains(@class, 'portalTechField__number')])");

        addElement("ReportTitle", "//*[@id='dummy-header-title']");
        addElement("PatentAssetsSummaryNumbers", "//*[contains(@class, 'patent-asset-block')]//b");
        addElement("TechAndPatentSummaryNumbers", "//*[contains(@class, 'tech-and-patent-block')]//b");
        addElement("ValidPatentsNumbers", "//*[contains(@class, 'table__body__row')]//b");
        addElement("HighValuePatentsNumbers", "//*[@id='patent-asset-block-collapse']//*[contains(@class, 'table__body__description')]//b");
        addElement("TechAndPatentTab", "//*[@i18n-txt='due.report.topic2']");
        addElement("MainTechFieldsNumbers", "//*[contains(@class, 'techAndPatentCount__header')]//b");

        addElement("Categories", "//*[contains(@class, 'portalCompanyDetailTable__button')]");

        addElement("MainLabelNumbers", "//*[contains(@class, 'portalNumberLabel__number')]");
        addElement("SubLabelNumbers", "//*[contains(@class, 'portalDescription__number')]");
        addElement("FieldLabelNumbers", "//*[contains(@class, 'portalTechField__number')]");

        addElement("SampleReports", "//*[contains(@class, 'portalSampleReport__link')]");

        addElement("SearchInput", "//*[contains(@class, 'companySearch__input')]");
        addElement("SearchSubmit", "//*[contains(@class, 'companySearch__icon')]//*[name()='svg' and contains(@class, 'fa-search')]");
        addElement("GoToPartySearch", "//*[contains(@i18n-txt, 'dd.portal.button.patentsearch')]");
    }

    protected void resetVars() {
        numberOfPatents = -1;
        numberOfCompanies = -1;
    }

    @Override
    public void navigate() {
        super.navigate();
        op.sleep(3000);
        op.clickAndWait(getElement("ChangeLang"), getElement("EnglishLang"));
		op.click(getElement("EnglishLang"));
    }

    public void isOnDDPortal() {
        resetVars();
        recordNumberOfCompanies();
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

    protected List<Integer> _parseNumbers(String target) {
        op.waitFor(getElement(target));
        List<WebElement> elements = op.findElements(getElement(target));
        List<Integer> list = new ArrayList<>();
        for (WebElement element : elements) {
            String[] arr = element.getText().split(" ");
            for (String s : arr) {
                Integer _int = NumberTool.parseIntFromString(s);
                if (_int != null) list.add(_int);
            }
        }
        return list;
    }

    protected void recordNumberOfPatents() {
        numberOfPatents = NumberTool.parseIntFromString(op.findElement(getElement("NumberOfPatents")).getText());
        System.out.println(numberOfPatents);
    }

    protected void parsePatentAssetsSummaryNumbers() {
        patentAssetsSummaryNumbers = _parseNumbers("PatentAssetsSummaryNumbers");
        System.out.println(Arrays.toString(patentAssetsSummaryNumbers.toArray()));
    }

    protected void parseTechAndPatentSummaryNumbers() {
        techAndPatentSummaryNumbers = _parseNumbers("TechAndPatentSummaryNumbers");
        System.out.println(Arrays.toString(techAndPatentSummaryNumbers.toArray()));
    }

    protected void compareNumberOfPatents() {
        if (numberOfPatents != patentAssetsSummaryNumbers.get(0)) {
            throw new RuntimeException("Number of Patents not matched: " + numberOfPatents + " != " + patentAssetsSummaryNumbers.get(0));
        }
    }

    public void viewReport() {
        recordNumberOfPatents();
        op.clickAndWait(getElement("ViewReport"), getElement("ReportTitle"));
        parsePatentAssetsSummaryNumbers();
        compareNumberOfPatents();
    }

    public void viewAllFieldsReport() {
        op.click(getElement("AllFields"));
        recordNumberOfPatents();
        op.clickAndWait(getElement("ViewReport"), getElement("ReportTitle"));
        parsePatentAssetsSummaryNumbers();
        compareNumberOfPatents();
    }

    public void clickFirstCompany() {
        return;
    }

    public void clickFirstUltimateParent() {
        if (op.isExist(getElement("UltimateParent"))) {
            op.click(getElement("UltimateParent"));
        } else if (op.isExist(getElement("CollapseButton"))) {
            List<WebElement> list = op.findElements(getElement("CollapseButton"));
            if (list.size() > 1) {
                for (int i = 1; i < list.size() - 1; i++) {
                    list.get(i).click();
                    op.sleep(3000);
                    if (op.isExist(getElement("UltimateParent"))) {
                        op.click(getElement("UltimateParent"));
                        break;
                    }
                }
            }
        }
    }

    public void clickLastCompany() {
        List<WebElement> list = op.findElements(getElement("CompanyList"));
        list.get(list.size() - 1).click();
    }

    public void clickLastUltimateParent() {
        if (op.isExist(getElement("CollapseButton"))) {
            List<WebElement> list = op.findElements(getElement("CollapseButton"));
            if (list.size() > 1) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    list.get(i).click();
                    op.sleep(3000);
                    if (op.isExist(getElement("UltimateParent"))) {
                        op.click(getElement("UltimateParent"));
                        break;
                    }
                }
            }
        }
    }

    public void rankByValidPatents() {
        op.selectDropdownMenuOptionByValue(getElement("RankingSelect"), "activePatentCount");
        waitForRanking();
        compareNumberOfCompanies();
        checkRankingNumbersDescending();
    }

    public void rankByHighValuePatents() {
        op.selectDropdownMenuOptionByValue(getElement("RankingSelect"), "highValuePatentCount");
        waitForRanking();
        compareNumberOfCompanies();
        checkRankingNumbersDescending();
    }

    public void rankByPatentsFiled() {
        op.selectDropdownMenuOptionByValue(getElement("RankingSelect"), "recentlyAppliedPatentCount");
        waitForRanking();
        compareNumberOfCompanies();
        checkRankingNumbersDescending();
    }

    public void rankByPatents() {
        op.selectDropdownMenuOptionByValue(getElement("RankingSelect"), "categoryPatentCount");
        waitForRanking();
        compareNumberOfCompanies();
        checkRankingNumbersDescending();
    }

    protected void recordNumberOfCompanies() {
        List<WebElement> list = op.findElements(getElement("CompanyList"));
        numberOfCompanies = list.size();
    }

    protected void compareNumberOfCompanies() {
        List<WebElement> list = op.findElements(getElement("CompanyList"));
        if (list.size() != numberOfCompanies) throw new RuntimeException("Number of companies not matched: " + list.size() + " != " + numberOfCompanies);
    }

    protected void waitForRanking() {
        Set<String> set = new HashSet<>(){{
            add(domain + "/dd-api/portal");
            add(domain + "/dd-api/portal/company");
        }};
        waitForRequests(set);
    }

    protected void checkRankingNumbersDescending() {
        List<WebElement> elements = op.findElements(getElement("RankingNumbers"));
        int prev = 0, current = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (i == 0) {
                prev = NumberTool.parseIntFromString(elements.get(i).getText());
            } else {
                current = NumberTool.parseIntFromString(elements.get(i).getText());
                if (current > prev) throw new RuntimeException("Numbers aren't descending: " + current + " > " + prev);
                prev = current;
            }
        }
    }

    public void changeFilters() {
        op.clickAndWait(getElement("FilterButton"), getElement("ParentCompany"));
        op.click(getElement("ParentCompany"));
        op.click(getElement("Subsidiary"));
        op.click(getElement("IndependentCompany"));
        op.click(getElement("SEPOwner"));
        op.click(getElement("3GPPMember"));
        op.clickAndWait(getElement("LargerThanZero"), getElement("ClearPercentage"));
        op.clickAndWait(getElement("LargerThanTwentyFive"), getElement("ClearPercentage"));
        op.clickAndWaitUntilDisappear(getElement("ClearPercentage"), getElement("ClearPercentage"));
        op.clickAndWaitUntilDisappear(getElement("FilterSubmit"), getElement("ParentCompany"));
        waitForFiltering();
    }

    public void waitForFiltering() {
        Set<String> set = new HashSet<>(){{
            add(domain + "/dd-api/portal");
        }};
        waitForRequests(set);
    }

    protected void waitForRequests(Set<String> requests) {

        int retry = 0, maxRetry = 20, millis = 6000;
        while (requests.size() > 0 && retry++ < maxRetry) {

            List<Map<String, String>> logs = op.getAllResponseUrlsFromLoggingPrefs();
            for (Map<String, String> log : logs) {

                String url = log.get("url"), status = log.get("status");
                if (url.contains(domain)) System.out.println(url);

                url = url.replaceAll("\\?.*", "");

                if (requests.contains(url)) {
                    System.out.println("==> " + url + " status = " + status);
                    if (status.equals("200")) requests.remove(url);
                    else throw new RuntimeException("request " + url + "return status " + status);
                }
            }
            op.sleep(millis);
        }

        if (requests.size() > 0) throw new RuntimeException("Cannot get response for: " + Arrays.toString(requests.toArray()) + " after " + maxRetry * millis / 1000 + " sec");

    }

}
