package automation.cucumber.steps.main;

import automation.cucumber.steps.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPageSteps extends BaseSteps {

    @When("navigate to dd portal")
    public void navigate_to_dd_portal() {
        mainPage.navigate();
    }

    @Given("on dd portal")
    public void on_dd_portal() {
        mainPage.isOnDDPortal();
    }

    @Then("login")
    public void login() { mainPage.login(); }

    @Then("logout")
    public void logout() {
        mainPage.logout();
    }

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

}
