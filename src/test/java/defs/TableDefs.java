package defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import steps.TableSteps;
import utils.DataTable;

public class TableDefs extends UIInteractionSteps {

    @Steps
    TableSteps tableSteps;

    @Given("User open page {string}")
    public void userOpenPage(String url) {
        openUrl(url);
    }

    @Then("User can read data using css {string} with name {string}")
    public void userCanReadDataUsingCssWithName(String selector, String tableName) {
        DataTable dataTable = new DataTable(selector, this);
        tableSteps.validateTable(dataTable, tableName);
    }
}
