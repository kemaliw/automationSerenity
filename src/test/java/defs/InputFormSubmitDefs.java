package defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.By;
import pages.InputFormSubmitPage;

public class InputFormSubmitDefs extends UIInteractionSteps {

    @Page
    InputFormSubmitPage inputFormSubmitPage;

    @When("All input fields are filled in")
    public void allInputFieldsAreFilledIn(DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            String name = row.get("name");
            WebElementFacade inputField = $(By.name(name));
            String insertText = row.get("text");
            inputField.type(insertText);
        });
    }

    @And("Dropdown state {string} is correctly set")
    public void dropdownStateIsCorrectlySet(String dropdown) {
        inputFormSubmitPage.getStateDropdown().selectByVisibleText(dropdown);
    }

    @And("Hosting radio button {string} is selected")
    public void hostingRadioButtonIsSelected(String radioButtonName) {
        inputFormSubmitPage.getRadioButton(radioButtonName).click();
    }

    @Then("User click on send button")
    public void userClickOnSendButton() {
        inputFormSubmitPage.getSendButton().click();
    }
}
