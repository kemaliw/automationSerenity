package defs;

import io.cucumber.java.en.And;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class CommonDefs extends UIInteractionSteps {

    @And("Click on the {string} button")
    public void clickOnTheButton(String button) {
        $(By.xpath("//button[text()='" + button + "']")).click();
    }
}
