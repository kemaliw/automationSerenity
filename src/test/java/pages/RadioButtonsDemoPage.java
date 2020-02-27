package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class RadioButtonsDemoPage extends PageObject {

    @FindBy(xpath = ".//div[@class='col-md-6 text-left']/div[1][contains(@class,'panel-default')]/div[@class='panel-heading']")
    private WebElementFacade headerRadioButtonDemo;
    /*@FindBy(css = "input[value=Male][name=optradio]")
    private WebElementFacade radioButtonMale;*/
    @FindBy(css = "p.radiobutton")
    private WebElementFacade getCheckValueMessage;
    @FindBy(id = "buttoncheck")
    private WebElementFacade buttonGetCheckedValue;
    @FindBy(xpath = ".//input[@value='0 - 5']")
    private WebElementFacade radioButtonAgeGroup0To5;

    @FindBy(css = "input[name='optradio']")
    private List<WebElementFacade> listOfRadioButtons;

    public WebElementFacade getOptRadioButton(String gender) {
        return $(By.cssSelector("input[value=" + gender + "][name=optradio]"));
    }

    public WebElementFacade getGenderRadioButton(String gender) {
        return $(By.cssSelector("input[value=" + gender + "][name=gender]"));
    }

    public WebElementFacade getHeaderRadioButtonDemo() {
        return headerRadioButtonDemo;
    }

    public WebElementFacade getButtonGetCheckedValue() {
        return buttonGetCheckedValue;
    }

    public WebElementFacade getRadioButtonAgeGroup0To5() {
        return radioButtonAgeGroup0To5;
    }

    public WebElementFacade getGetCheckValueMessage() {
        return getCheckValueMessage;
    }

    public List<WebElementFacade> getListOfRadioButtons() {
        return listOfRadioButtons;
    }
}
