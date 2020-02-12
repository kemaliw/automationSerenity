package defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.CheckboxDemoPage;
import steps.CheckboxDemoSteps;

public class CheckboxDemoDefs {

    @Page
    CheckboxDemoPage checkboxDemoPage;
    @Steps
    CheckboxDemoSteps checkboxDemoSteps;
    private WebElementFacade checkbox;

    @Then("User selects checkbox")
    public void userSelectsCheckbox() {
        WebElementFacade checkboxSingleDemo = checkboxDemoPage.getCheckboxSingleDemo();
        checkboxSingleDemo.click();
        Assert.assertThat("Checkbox is selected", checkboxSingleDemo.isSelected(), Matchers.equalTo(true));
    }

    @And("Proper message {string} is displayed.")
    public void properMessageIsDisplayed(String message) {
        Assert.assertThat("Improper text message after selecting checkbox", checkboxDemoPage.getMessageSuccessCheckBoxIsSelected().getText(), Matchers.equalTo(message));
    }

    @When("User click on Check All button")
    public void userClickOnCheckAllButton() {
        checkboxDemoSteps.clickOnCheckAllButton();
    }

    @Then("All checkboxes are selected")
    public void allCheckboxesAreSelected() {
        SoftAssertions softAssertions = new SoftAssertions();
        checkboxDemoPage.getCheckboxesList().forEach(check -> {
            softAssertions.assertThat(check.isSelected()).as(check.getText()).isTrue();
        });
        softAssertions.assertAll();
    }

    @And("Button name was changed to {string}")
    public void buttonNameWasChangedTo(String message) {
        Assert.assertThat("Button name was not changed to Uncheck All", checkboxDemoPage.getButtonCheckAll().getValue(), Matchers.equalTo(message));
    }

    @When("User unselect {int} checkboxes")
    public void userUnselectCheckboxes(int amountToUnselect) {
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < amountToUnselect; i++) {
            checkbox = checkboxDemoPage.getCheckboxesList().get(i);
            checkbox.click();
            softAssertions.assertThat(checkbox.isSelected()).as(checkbox.getText()).isFalse();
        }

        for (int i = 0; i < checkboxDemoPage.getCheckboxesList().size() && i < amountToUnselect; i++) {
            softAssertions.assertThat(checkbox.isSelected()).as(checkbox.getText()).isFalse();
        }
        softAssertions.assertAll();
    }
}
