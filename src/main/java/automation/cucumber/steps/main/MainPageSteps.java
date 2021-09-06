package automation.cucumber.steps.main;

import automation.cucumber.steps.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

public class MainPageSteps extends BaseSteps {

    @When("navigate to dd portal")
    public void navigate_to_dd_portal() {
        mainPage.navigate();
    }

    @Given("on dd portal")
    public void on_dd_portal() {
        mainPage.isOnDDPortal();
    }

    @Then("try to login")
    public void try_to_login() throws AWTException { mainPage.tryToLogin(); }

    @Then("login")
    public void login() { mainPage.login(); }

    @Then("logout")
    public void logout() {
        mainPage.logout();
    }

    @Then("rank by valid patents")
    public void rank_by_valid_patents() { mainPage.rankByValidPatents(); }

    @Then("rank by high value patents")
    public void rank_by_high_value_patents() { mainPage.rankByHighValuePatents(); }

    @Then("rank by patents filed")
    public void rank_by_patents_filed() { mainPage.rankByPatentsFiled(); }

    @Then("rank by patents")
    public void rank_by_patents() { mainPage.rankByPatents(); }

    @Then("change filters")
    public void change_filters() { mainPage.changeFilters(); }

    @Then("search")
    public void search() { mainPage.search(); }

    @Then("trending")
    public void trending() { mainPage.trending(); }

    @Then("party search")
    public void party_search() { mainPage.partySearch(); }

    @Then("click first company")
    public void click_first_company() { mainPage.clickFirstCompany(); }

    @Then("click first ultimate parent")
    public void click_first_ultimate_parent() { mainPage.clickFirstUltimateParent(); }

    @Then("click last company")
    public void click_last_company() { mainPage.clickLastCompany(); }

    @Then("click last ultimate parent")
    public void click_last_ultimate_parent() { mainPage.clickLastUltimateParent(); }

    @Then("view report")
    public void view_report() { mainPage.viewReport(); }

    @Then("view all fields report")
    public void view_all_fields_report() { mainPage.viewAllFieldsReport(); }

}
