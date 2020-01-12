package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class BootstrapAlertPage extends PageObject {

    @FindBy(id = "autoclosable-btn-success")
    private WebElementFacade autocloseableSuccessMessageButton;
    @FindBy(id = "normal-btn-success")
    private WebElementFacade normalSuccessMessageButton;
    @FindBy(id = "autoclosable-btn-warning")
    private WebElementFacade autocloseableWarningMessageButton;
    @FindBy(id = "normal-btn-warning")
    private WebElementFacade normalWarningMessageButton;
    @FindBy(id = "autoclosable-btn-danger")
    private WebElementFacade autoclosableDangerMessageButton;
    @FindBy(id = "normal-btn-danger")
    private WebElementFacade normalDangerMessageButton;
    @FindBy(id = "autoclosable-btn-info")
    private WebElementFacade autoclosaInfoMessageButton;
    @FindBy(id = "normal-btn-info")
    private WebElementFacade normalInfoMessageButton;

    public List<WebElementFacade> getAlertButtons() {
        return alertButtons;
    }

    @FindBy(css = ".col-md-4 button")
    private List<WebElementFacade> alertButtons;

    public WebElementFacade getAutocloseableSuccessMessageButton() {
        return autocloseableSuccessMessageButton;
    }

    public WebElementFacade getNormalSuccessMessageButton() {
        return normalSuccessMessageButton;
    }

    public WebElementFacade getAutocloseableWarningMessageButton() {
        return autocloseableWarningMessageButton;
    }

    public WebElementFacade getNormalWarningMessageButton() {
        return normalWarningMessageButton;
    }

    public WebElementFacade getAutoclosableDangerMessageButton() {
        return autoclosableDangerMessageButton;
    }

    public WebElementFacade getNormalDangerMessageButton() {
        return normalDangerMessageButton;
    }

    public WebElementFacade getAutoclosaInfoMessageButton() {
        return autoclosaInfoMessageButton;
    }

    public WebElementFacade getNormalInfoMessageButton() {
        return normalInfoMessageButton;
    }

    public List<WebElementFacade> getAlertByText(String text) {
        return $$(By.xpath("//div[contains(@class,'alert')][text()[contains(normalize-space(.),'" + text + "')]]"));
    }
}
