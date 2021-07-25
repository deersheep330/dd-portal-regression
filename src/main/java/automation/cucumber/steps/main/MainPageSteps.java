package automation.cucumber.steps.main;

import automation.cucumber.steps.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainPageSteps extends BaseSteps {
	
	@When("navigate to Essentiality Ranking")
    public void navigate_to_Essentiality_Ranking() {
        mainPage.waitForEssentialityRanking();
    }
	
	@Then("click and validate Essentiality Ranking")
    public void click_and_validate_Essentiality_Ranking() {
        mainPage.clickAndValidateEssentialityRanking();
    }
	
	@Then("click and validate High Claim Chart")
    public void click_and_validate_High_Claim_Chart() {
        mainPage.clickAndValidateHighClaimChart();
    }
	
	@Then("click and validate Mid Claim Chart")
    public void click_and_validate_Mid_Claim_Chart() {
        mainPage.clickAndValidateMidClaimChart();
    }
	
	@Then("click and validate Low Claim Chart")
    public void click_and_validate_Low_Claim_Chart() {
        mainPage.clickAndValidateLowClaimChart();
    }
	
	@Then("click and validate Expand Claim Chart")
    public void click_and_validate_Expand_Claim_Chart() {
        mainPage.clickAndValidateExpandClaimChart();
    }
	
	@Then("test claim chart summary options")
    public void test_claim_chart_summary_options() {
        mainPage.testClaimChartSummaryOptions();
    }

    @When("navigate to sep")
    public void navigate_to_sep() {
        if (background.isMet()) return;
        mainPage.navigate();
    }

    @When("navigate to sit sep")
    public void navigate_to_sit_sep() {
        mainPage.navigateToSIT();
    }

    @When("navigate to stage sep")
    public void navigate_to_stage_sep() {
        mainPage.navigateToStage();
    }

    @Then("navigate to declaration status tab")
    public void navigate_to_declaration_status_tab() {
        if (background.isMet()) return;
        mainPage.switchToDeclarationStatus();
    }

    @Given("on declaration status tab")
    public void on_declaration_status_tab() {
        mainPage.makeSureOnDeclarationStatus();
    }

    @Then("navigate to company profile tab")
    public void navigate_to_company_profile_tab() {
        mainPage.switchToCompanyProfile();
    }

    @Then("navigate to company list tab")
    public void navigate_to_company_list_tab() {
        if (background.isMet()) return;
        mainPage.switchToCompanyList();
    }

    @Given("on company profile tab")
    public void on_company_profile_tab() {
        mainPage.makeSureOnCompanyProfile();
    }

    @Then("login")
    public void login() {
        mainPage.login();
    }

    @Then("login as pv user")
    public void login_as_pv_user() {
        mainPage.loginAsPVUser();
    }

    @Then("logout")
    public void logout() {
        mainPage.logout();
    }

    @Then("close patent list modal")
    public void close_patent_list_modal() {
        mainPage.closePatentListModal();
    }

    @Then("close newly opened tabs")
    public void close_newly_opened_tabs() {
        mainPage.closeNewlyOpenedTabs();
    }

    @Then("export to PV")
    public void export_to_PV() {
        mainPage.exportToPV();
    }

    @Then("export to excel")
    public void export_to_excel() {
        mainPage.exportToExcel();
    }

    @Then("export to excel without comparison")
    public void export_to_excel_without_comparison() {
        mainPage.exportToExcelWithoutComparison();
    }

    @Then("export to csv")
    public void export_to_csv() {
        mainPage.exportToCsv();
    }

    @Then("export to full text")
    public void export_to_full_text() {
        mainPage.exportToFullText();
    }

    @Then("export to front page")
    public void export_to_front_page() {
        mainPage.exportToFrontPage();
    }

    @Then("select all in patent list modal")
    public void select_all_in_patent_list_modal() {
        mainPage.patentListSelectAll();
    }

    @Then("select one in patent list modal")
    public void selectOneInPatentListModal() {
        mainPage.patentListSelectOne();
    }

    @Then("toggle well maintained")
    public void toggle_well_maintained() { mainPage.toggleWellMaintained(); }

    @Then("change all scope settings")
    public void change_all_scope_settings() {
        mainPage.changeAllScopeSettings();
    }

    @Then("reset scope settings")
    public void reset_scope_settings() {
        mainPage.resetScopeSettings();
    }

    @Then("check if scope settings changed")
    public void check_if_scope_settings_changed() {
        mainPage.checkIfScopeSettingsChanged();
    }

    @Then("check if scope settings reset")
    public void check_if_scope_settings_reset() {
        mainPage.checkIfScopeSettingsReset();
    }

    @Then("add to watchlist")
    public void add_to_watchlist() {
        mainPage.addToWatchlist();
    }

    @Then("navigate to watchlist")
    public void navigate_to_watchlist() {
        mainPage.switchToWatchlist();
    }

    @Then("navigate to watchlist declaration status tab")
    public void navigate_to_watchlist_declaration_status_tab() {
        mainPage.switchToWatchlistDeclarationStatusTab();
    }

    @Then("navigate to watchlist company profile tab")
    public void navigate_to_watchlist_company_profile_tab() {
        mainPage.switchToWatchlistCompanyProfileTab();
    }

    @Then("set board as default")
    public void set_board_as_default() {
        mainPage.setBoardAsDefault();
    }

    @Then("delete board")
    public void delete_board() {
        mainPage.deleteBoard();
    }

    @Then("visit share link")
    public void visitShareLink() {
        mainPage.visitShareLink();
    }

    @Then("check if redirected to declaration status tab")
    public void checkIfRedirectedToDeclarationStatusTab() {
        mainPage.isRedirectedToDeclarationStatusTab();
    }

    @Then("check if redirected to declaring company sub tab")
    public void checkIfRedirectedToDeclaringCompanySubTab() {
        mainPage.isRedirectedToDeclaringCompanySubTab();
    }

    @Then("open filter settings")
    public void openFilterSettings() {
        mainPage.openFilterSettings();
    }

    @Then("close filter settings")
    public void closeFilterSettings() {
        mainPage.closeFilterSettings();
    }

    @Then("select fiveg preset")
    public void selectFivegPreset() {
        mainPage.selectFivegPreset();
    }

    @Then("select lte preset")
    public void selectLtePreset() {
        mainPage.selectLtePreset();
    }

    @Then("deselect lte preset")
    public void deselectLtePreset() {
        mainPage.deselectLtePreset();
    }

    @Then("select well maintained")
    public void selectWellMaintained() {
        mainPage.selectWellMaintained();
    }

    @Then("deselect well maintained")
    public void deselectWellMaintained() {
        mainPage.deselectWellMaintained();
    }

    @Then("select country us")
    public void selectCountryUs() {
        mainPage.selectCountryUs();
    }

    @Then("release should contain na and fifteen and sixteen and seventeen")
    public void releaseShouldContainNaAndFifteenAndSixteenAndSeventeen() {
        mainPage.releaseShouldContainNaAndFifteenAndSixteenAndSeventeen();
    }

    @Then("release should contain na and eight to fourteen")
    public void releaseShouldContainNaAndEightToFourteen() {
        mainPage.releaseShouldContainNaAndEightToFourteen();
    }

    @Then("release should contain na and eight to seventeen")
    public void releaseShouldContainNaAndEightToSeventeen() {
        mainPage.releaseShouldContainNaAndEightToSeventeen();
    }

    @Then("release should contain all")
    public void releaseShouldContainAll() {
        mainPage.releaseShouldContainAll();
    }

    @Then("declared from should contain fiveg start date")
    public void declaredFromShouldContainFivegStartDate() {
        mainPage.declaredFromShouldContainFivegStartDate();
    }

    @Then("declared from should contain lte start date")
    public void declaredFromShouldContainLteStartDate() {
        mainPage.declaredFromShouldContainLteStartDate();
    }

    @Then("declared from should be empty")
    public void declaredFromShouldBeEmpty() {
        mainPage.declaredFromShouldBeEmpty();
    }

    @Then("country should contain us")
    public void countryShouldContainUs() {
        mainPage.countryShouldContainUs();
    }

    @Then("country should contain all")
    public void countryShouldContainAll() {
        mainPage.countryShouldContainAll();
    }

    @Then("radio tech should contain fiveg")
    public void radioTechShouldContainFiveg() {
        mainPage.radioTechShouldContainFiveg();
    }

    @Then("radio tech should contain lte")
    public void radioTechShouldContainLte() {
        mainPage.radioTechShouldContainLte();
    }

    @Then("radio tech should contain lte and fiveg")
    public void radioTechShouldContainLteAndFiveg() {
        mainPage.radioTechShouldContainLteAndFiveg();
    }

    @Then("radio tech should contain all")
    public void radioTechShouldContainAll() {
        mainPage.radioTechShouldContainAll();
    }

    @Then("select newly declared")
    public void selectNewlyDeclared() {
        mainPage.selectNewlyDeclared();
    }

    @Then("deselect newly declared")
    public void deselectNewlyDeclared() {
        mainPage.deselectNewlyDeclared();
    }

    @Then("select widely deployed")
    public void selectWidelyDeployed() {
        mainPage.selectWidelyDeployed();
    }

    @Then("deselect widely deployed")
    public void deselectWidelyDeployed() {
        mainPage.deselectWidelyDeployed();
    }

    @Then("select release fifteen")
    public void selectReleaseFifteen() {
        mainPage.selectReleaseFifteen();
    }

    @Then("select radio tech fiveg")
    public void selectRadioTechFiveg() {
        mainPage.selectRadioTechFiveg();
    }

    @Then("select tech body ranone")
    public void selectTechBodyRanone() {
        mainPage.selectTechBodyRanone();
    }

    @Then("select threegpp thirty eight")
    public void selectThreegppThirtyEight() {
        mainPage.selectThreegppThirtyEight();
    }

    @Then("select declaring company apple")
    public void selectDeclaringCompanyApple() {
        mainPage.selectDeclaringCompanyApple();
    }

    @Then("select legal status active")
    public void selectLegalStatusActive() {
        mainPage.selectLegalStatusActive();
    }

    @Then("select legal status select all")
    public void selectLegalStatusSelectAll() {
        mainPage.selectLegalStatusSelectAll();
    }

    @Then("select declared from twenty fifteen")
    public void selectDeclaredFromTwentyFifteen() {
        mainPage.selectDeclaredFromTwentyFifteen();
    }

    @Then("select declared to twenty sixteen")
    public void selectDeclaredToTwentySixteen() {
        mainPage.selectDeclaredToTwentySixteen();
    }

    @Then("newly declared should be selected")
    public void newlyDeclaredShouldBeSelected() {
        mainPage.newlyDeclaredShouldBeSelected();
    }

    @Then("widely deployed should be selected")
    public void widelyDeployedShouldBeSelected() {
        mainPage.widelyDeployedShouldBeSelected();
    }

    @Then("well maintained should be selected")
    public void wellMaintainedShouldBeSelected() {
        mainPage.wellMaintainedShouldBeSelected();
    }

    @Then("release should contain fifteen")
    public void releaseShouldContainFifteen() {
        mainPage.releaseShouldContainFifteen();
    }

    @Then("tech body should contain ranone")
    public void techBodyShouldContainRanone() {
        mainPage.techBodyShouldContainRanone();
    }

    @Then("threegpp should contain thirty eight")
    public void threegppShouldContainThirtyEight() {
        mainPage.threegppShouldContainThirtyEight();
    }

    @Then("legal status should contain active")
    public void legalStatusShouldContainActive() {
        mainPage.legalStatusShouldContainActive();
    }

    @Then("declared from should contain twenty fifteen")
    public void declaredFromShouldContainTwentyFifteen() {
        mainPage.declaredFromShouldContainTwentyFifteen();
    }

    @Then("declared to should contain twenty sixteen")
    public void declaredToShouldContainTwentySixteen() {
        mainPage.declaredToShouldContainTwentySixteen();
    }

    @Then("select release sixteen")
    public void selectReleaseSixteen() {
        mainPage.selectReleaseSixteen();
    }

    @Then("select radio tech lte")
    public void selectRadioTechLte() {
        mainPage.selectRadioTechLte();
    }

    @Then("select tech body rantwo")
    public void selectTechBodyRantwo() {
        mainPage.selectTechBodyRantwo();
    }

    @Then("select threegpp thirty seven")
    public void selectThreegppThirtySeven() {
        mainPage.selectThreegppThirtySeven();
    }

    @Then("select declaring company huawei")
    public void selectDeclaringCompanyHuawei() {
        mainPage.selectDeclaringCompanyHuawei();
    }

    @Then("select country cn")
    public void selectCountryCn() {
        mainPage.selectCountryCn();
    }

    @Then("select legal status pending")
    public void selectLegalStatusPending() {
        mainPage.selectLegalStatusPending();
    }

    @Then("select declared from twenty seventeen")
    public void selectDeclaredFromTwentySeventeen() {
        mainPage.selectDeclaredFromTwentySeventeen();
    }

    @Then("select declared to twenty eighteen")
    public void selectDeclaredToTwentyEighteen() {
        mainPage.selectDeclaredToTwentyEighteen();
    }

    @Then("newly declared should be deselected")
    public void newlyDeclaredShouldBeDeselected() {
        mainPage.newlyDeclaredShouldBeDeselected();
    }

    @Then("widely deployed should be deselected")
    public void widelyDeployedShouldBeDeselected() {
        mainPage.widelyDeployedShouldBeDeselected();
    }

    @Then("well maintained should be deselected")
    public void wellMaintainedShouldBeDeselected() {
        mainPage.wellMaintainedShouldBeDeselected();
    }

    @Then("release should contain sixteen")
    public void releaseShouldContainSixteen() {
        mainPage.releaseShouldContainSixteen();
    }

    @Then("tech body should contain rantwo")
    public void techBodyShouldContainRantwo() {
        mainPage.techBodyShouldContainRantwo();
    }

    @Then("threegpp should contain thirty seven")
    public void threegppShouldContainThirtySeven() {
        mainPage.threegppShouldContainThirtySeven();
    }

    @Then("country should contain cn")
    public void countryShouldContainCn() {
        mainPage.countryShouldContainCn();
    }

    @Then("legal status should contain pending")
    public void legalStatusShouldContainPending() {
        mainPage.legalStatusShouldContainPending();
    }

    @Then("declared from should contain twenty seventeen")
    public void declaredFromShouldContainTwentySeventeen() {
        mainPage.declaredFromShouldContainTwentySeventeen();
    }

    @Then("declared to should contain twenty eighteen")
    public void declaredToShouldContainTwentyEighteen() {
        mainPage.declaredToShouldContainTwentyEighteen();
    }

    @Then("submit filter settings")
    public void submitFilterSettings() {
        mainPage.submitFilterSettings();
    }

    @Then("declaring company should be huawei")
    public void declaringCompanyShouldBeHuawei() {
        mainPage.declaringCompanyShouldBeHuawei();
    }

    @Then("declaring company should be apple")
    public void declaringCompanyShouldBeApple() {
        mainPage.declaringCompanyShouldBeApple();
    }

}
