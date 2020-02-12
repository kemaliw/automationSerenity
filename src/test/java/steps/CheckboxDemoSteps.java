package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import pages.CheckboxDemoPage;

public class CheckboxDemoSteps extends UIInteractionSteps {

    @Page
    CheckboxDemoPage checkboxDemoPage;

    @Step
    public void clickOnCheckAllButton() {
        checkboxDemoPage.getButtonCheckAll().click();
    }
}
