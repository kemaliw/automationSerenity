package defs;

import io.cucumber.java.en.Given;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigationDefs extends UIInteractionSteps {

    @Given("User open page {string}")
    public void userOpenPage(String url) {
        openUrl(url);
    }
}
