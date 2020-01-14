package defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fluentlenium.core.annotation.Page;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.SimpleFormDemoPage;
import steps.SimpleFormDemoSteps;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class SimpleFormDemoDefs {

    @Page
    SimpleFormDemoPage simpleFormDemoPage;

    @Steps
    SimpleFormDemoSteps simpleFormDemoSteps;
    private List<String> testData;

    @When("User type  {string} message into input field")
    @Step
    public void userTypeMessageIntoInputField(String message) {
        simpleFormDemoPage.getInputFieldYourMessage().type(message);
    }

    @And("Press show message button")
    @Step
    public void pressShowMessageButton() {
        simpleFormDemoPage.getButtonShowMessage().click();
    }

    @Then("Message {string} is displayed")
    @Step
    public void messageIsDisplayed(String message) {
        Assert.assertThat(simpleFormDemoPage.getMessageDisplay().getText(), Matchers.containsString(message));
    }

    @When("Using test data from file {string}")
    public void usingTestDataFromFile(String filePath) throws IOException {
        String path = getClass().getClassLoader().getResource(filePath).getFile();
        testData = Files.readAllLines(Paths.get(new File(path).toString()));
    }

    @Then("Messages is displayed for all entries")
    public void messagesIsDisplayedForAllEntries() {
        testData.stream().skip(1)
                .forEach(test ->{
                    userTypeMessageIntoInputField(test);
                    pressShowMessageButton();
                    messageIsDisplayed(test);
                });
    }

    @Then("User enter values A {int} and value B {int} and result is displayed")
    public void userEnterValuesAAndValueBAndResultIsDisplayed(int a, int b) {
        simpleFormDemoSteps.enterNumbers(a,b);
        simpleFormDemoSteps.clickOnTotalSumButton();
        Assert.assertThat("Sum is invalid for numbers " + a + "," + b,
                Integer.parseInt(simpleFormDemoPage.getTotalValue().getText()), Matchers.equalTo(a+b));
    }

    @Then("User can sum {int} random numbers")
    public void userCanSumRandomNumbers(int n) {
        for (int i = 0; i < n; i++) {
            userEnterValuesAAndValueBAndResultIsDisplayed(new Random().nextInt(100),new Random().nextInt(100));
        }
    }
}
