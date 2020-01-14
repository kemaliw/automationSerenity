package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SimpleFormDemoPage extends PageObject {

    @FindBy(css = "#easycont h3")
    private WebElementFacade headerMain;
    @FindBy(xpath = "//div[contains(text(),'Single Input Field')]")
    private WebElementFacade headerSingleInputField;
    @FindBy(css = "#get-input > div > label")
    private WebElementFacade labelEnterMessage;
    @FindBy(css = "#get-input #user-message")
    private WebElementFacade inputFieldYourMessage;
    @FindBy(css = "#get-input > button")
    private WebElementFacade buttonShowMessage;
    @FindBy(css = "#user-message > label")
    private WebElementFacade labelYourMessage;
    @FindBy(css = "#display")
    private WebElementFacade messageDisplay;
    @FindBy(xpath = "//div[contains(text(),'Two Input Fields')]")
    private WebElementFacade headerTwoInputFields;
    @FindBy(css = "value1")
    private WebElementFacade labelEnterA;
    @FindBy(id = "sum1")
    private WebElementFacade inputFieldA;
    @FindBy(css = "value2")
    private WebElementFacade labelEnterB;
    @FindBy(id = "sum2")
    private WebElementFacade inputFieldB;
    @FindBy(css = "#gettotal > button")
    private WebElementFacade buttonGetTotal;
    @FindBy(xpath = "//*[@id='displayvalue']/../label")
    private WebElementFacade labelTotalSumAB;
    @FindBy(id = "displayvalue")
    private WebElementFacade totalValue;

    public WebElementFacade getHeaderMain() {
        return headerMain;
    }

    public WebElementFacade getHeaderSingleInputField() {
        return headerSingleInputField;
    }

    public WebElementFacade getLabelEnterMessage() {
        return labelEnterMessage;
    }

    public WebElementFacade getInputFieldYourMessage() {
        return inputFieldYourMessage;
    }

    public WebElementFacade getButtonShowMessage() {
        return buttonShowMessage;
    }

    public WebElementFacade getLabelYourMessage() {
        return labelYourMessage;
    }

    public WebElementFacade getMessageDisplay() {
        return messageDisplay;
    }

    public WebElementFacade getHeaderTwoInputFields() {
        return headerTwoInputFields;
    }

    public WebElementFacade getLabelEnterA() {
        return labelEnterA;
    }

    public WebElementFacade getInputFieldA() {
        return inputFieldA;
    }

    public WebElementFacade getLabelEnterB() {
        return labelEnterB;
    }

    public WebElementFacade getInputFieldB() {
        return inputFieldB;
    }

    public WebElementFacade getButtonGetTotal() {
        return buttonGetTotal;
    }

    public WebElementFacade getLabelTotalSumAB() {
        return labelTotalSumAB;
    }

    public WebElementFacade getTotalValue() {
        return totalValue;
    }
}
