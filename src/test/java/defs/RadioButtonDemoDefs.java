package defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.RadioButtonsDemoPage;

public class RadioButtonDemoDefs {

    private String expectedGenderMessage;

    @Page
    RadioButtonsDemoPage radioButtonsDemoPage;

    @When("Click on the {string} radio button")
    public void clickOnTheRadioButton(String option) {
        radioButtonsDemoPage.getOptRadioButton(option).click();
    }


    @Then("{string} message is displayed")
    public void messageIsDisplayed(String message) {
        Assert.assertEquals(message, radioButtonsDemoPage.getGetCheckValueMessage().getText());
    }

    @When("User select next radio button from Radio Button Demo")
    public void userSelectNextRadioButtonFromRadioButtonDemo() {
        for (WebElementFacade radio : radioButtonsDemoPage.getListOfRadioButtons()) {
            if (!radio.isSelected()) {
                radio.click();
                expectedGenderMessage = radio.thenFind("./..").getText();
                break;
            }
        }
    }

    @Then("Correct radio button message is displayed")
    public void correctRadioButtonMessageIsDisplayed() {
        Assert.assertEquals(String.format("Radio button '%s' is checked", expectedGenderMessage), radioButtonsDemoPage.getGetCheckValueMessage().getText());
    }
}
