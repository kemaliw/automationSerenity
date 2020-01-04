package defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.DuckHomePage;
import pages.DuckResultPage;
import steps.DuckSteps;

public class DuckDefs {

    @Steps
    DuckSteps duckSteps;
    @Page
    DuckHomePage duckHomePage;
    @Page
    DuckResultPage duckResultPage;

    @Given("User opend duck page")
    public void userOpendDuckPage() {
        duckSteps.openDuckPage();
    }

    @And("Search for {string}")
    public void searchFor(String item) {
        duckHomePage.getSearchInput().typeAndEnter(item);
    }

    @Then("Results are displayed")
    public void resultsAreDisplayed() {
        Assert.assertEquals(duckResultPage.getResults().size(),10);
    }
}
