package com.vytrack.step_definitions;

import com.vytrack.pages.AccountPage;
import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class US12StepDefs extends BasePage {
    AccountPage accountPage = new AccountPage();


    @Given("The user is on the DashboardPage")
    public void the_user_is_on_the_dashboard_page() {
        BrowserUtilities.waitForTitleContains("Dashboard");
        BrowserUtilities.verifyTitle("Dashboard");
    }

    @When("User hovers mouse over {string} tab and click {string} module")
    public void user_hovers_mouse_over_module_and_click_on_the_submenu(String tab, String module) {
        navigateToModule(tab, module);

    }

    @And("User go to the {string}")
    public void userGoToThe(String title) {
        BrowserUtilities.waitForTitleContains(title);
        BrowserUtilities.verifyTitle(title);
    }

    @Then("User should be able to see  below eight filter items on the Accounts page")
    public void user_should_be_able_to_see_below_filter_eight_items_on_the_accounts_page(List<String> expectedFilters) {

        accountPage.filterIcon.click();
        List<String> actualFilterHeaders = new ArrayList<>();
        for (WebElement el : accountPage.filters) {
            String[] actualText = el.getText().split(":");
            actualFilterHeaders.add(actualText[0]);
        }
        Assert.assertEquals(expectedFilters, actualFilterHeaders);
    }


}
