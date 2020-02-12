package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CheckboxDemoPage extends PageObject {
    @FindBy(css = "#easycont h3")
    private WebElementFacade headerMain;
    @FindBy(xpath = "//div[contains(text(),'Single Checkbox Demo')]")
    private WebElementFacade headerSingleCheckboxDemo;
    @FindBy(id = "isAgeSelected")
    private WebElementFacade checkboxSingleDemo;
    @FindBy(xpath = "//*[@id='isAgeSelected']/..")
    private WebElementFacade labelClickOnThisCheckBox;
    @FindBy(id = "txtAge")
    private WebElementFacade messageSuccessCheckBoxIsSelected;
    @FindBy(xpath = "//*[text()='Option 1']/input")
    private WebElementFacade checkboxOption1;
    @FindBy(xpath = "//*[text()='Option 2']/input")
    private WebElementFacade checkboxOption2;
    @FindBy(xpath = "//*[text()='Option 3']/input")
    private WebElementFacade checkboxOption3;
    @FindBy(xpath = "//*[text()='Option 4']/input")
    private WebElementFacade checkboxOption4;
    @FindBy(id = "check1")
    private WebElementFacade buttonCheckAll;
    @FindBy(xpath = "//label[contains(.,'Option')]/input")
    private List<WebElementFacade> checkboxesList;

    public WebElementFacade getHeaderMain() {
        return headerMain;
    }

    public WebElementFacade getHeaderSingleCheckboxDemo() {
        return headerSingleCheckboxDemo;
    }

    public WebElementFacade getCheckboxSingleDemo() {
        return checkboxSingleDemo;
    }

    public WebElementFacade getLabelClickOnThisCheckBox() {
        return labelClickOnThisCheckBox;
    }

    public WebElementFacade getCheckboxOption1() {
        return checkboxOption1;
    }

    public WebElementFacade getCheckboxOption2() {
        return checkboxOption2;
    }

    public WebElementFacade getCheckboxOption3() {
        return checkboxOption3;
    }

    public WebElementFacade getCheckboxOption4() {
        return checkboxOption4;
    }

    public WebElementFacade getButtonCheckAll() {
        return buttonCheckAll;
    }

    public WebElementFacade getMessageSuccessCheckBoxIsSelected() {
        return messageSuccessCheckBoxIsSelected;
    }

    public List<WebElementFacade> getCheckboxesList() {
        return checkboxesList;
    }
}
