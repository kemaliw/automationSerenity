package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import pages.SimpleFormDemoPage;

public class SimpleFormDemoSteps extends UIInteractionSteps {

    @Page
    SimpleFormDemoPage simpleFormDemoPage;

    @Step
    public void enterNumbers(int a, int b){
        simpleFormDemoPage.getInputFieldA().type(Integer.toString(a));
        simpleFormDemoPage.getInputFieldB().type(Integer.toString(b));
    }

    @Step
    public void clickOnTotalSumButton(){
        simpleFormDemoPage.getButtonGetTotal().click();
    }
}
