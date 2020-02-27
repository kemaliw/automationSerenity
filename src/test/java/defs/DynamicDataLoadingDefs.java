package defs;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.DynamicDataLoadingPage;

import java.time.Duration;
import java.util.Set;
import java.util.TreeSet;

public class DynamicDataLoadingDefs extends UIInteractionSteps {

    @Page
    DynamicDataLoadingPage dynamicDataLoadingPage;

    @Then("Press on get new user button {int} times")
    public void pressOnGetNewUserButtonTimes(int amount) {
       Set<String> text = new TreeSet<>();
        for (int i = 0; i < amount; i++) {
            dynamicDataLoadingPage.getGetNewUserButton().click();
            waitForCondition().withTimeout(Duration.ofSeconds(10)).until(webDriver -> {
                String textContent = dynamicDataLoadingPage.getContent().getTextContent();
                System.out.println("textContent = " + textContent);
                return !textContent.contains("loading");
            });
            text.add(dynamicDataLoadingPage.getContent().getTextContent());
        }

        Assert.assertEquals(amount,text.size());
    }
}
