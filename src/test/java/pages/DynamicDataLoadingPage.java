package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DynamicDataLoadingPage extends PageObject {
    @FindBy(id = "save")
    private WebElementFacade getNewUserButton;
    @FindBy(css = "#loading img")
    private WebElementFacade picture;
    @FindBy(id = "loading")
    private WebElementFacade content;

    public WebElementFacade getGetNewUserButton() {
        return getNewUserButton;
    }

    public WebElementFacade getPicture() {
        return picture;
    }

    public WebElementFacade getContent() {
        return content;
    }
}
