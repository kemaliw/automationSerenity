package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class InputFormSubmitPage extends PageObject {
    @FindBy(css = "#contact_form > fieldset > div:nth-child(8) > label")
    private WebElementFacade stateLabel;
    @FindBy(name = "state")
    private WebElementFacade stateDropdown;
    @FindBy(css = "#contact_form > fieldset > div:nth-child(11) > label")
    private WebElementFacade doYouHaveHostingLabel;
    @FindBy(css = "button[class='btn btn-default']")
    private WebElementFacade sendButton;

    public WebElementFacade getInputField(String name) {
        return $(By.cssSelector("[name=" + name + "]"));
    }

    public WebElementFacade getRadioButton(String radioButtonName) {
        return $(By.xpath("//input[@name='hosting' and @value='" + radioButtonName + "']"));
    }

    public WebElementFacade getStateLabel() {
        return stateLabel;
    }

    public WebElementFacade getStateDropdown() {
        return stateDropdown;
    }

    public WebElementFacade getDoYouHaveHostingLabel() {
        return doYouHaveHostingLabel;
    }

    public WebElementFacade getSendButton() {
        return sendButton;
    }
}
