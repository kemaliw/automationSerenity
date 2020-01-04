package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://duckduckgo.com")
public class DuckHomePage extends PageObject {

    @FindBy(id = "search_form_input_homepage")
    private WebElementFacade searchInput;
    @FindBy(id="search_button_homepage")
    private WebElementFacade searchButton;

    public WebElementFacade getSearchInput() {
        return searchInput;
    }

    public WebElementFacade getSearchButton() {
        return searchButton;
    }
}
