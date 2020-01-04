package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class DuckResultPage extends PageObject {

    @FindBy(css=".result__title")
    private List<WebElementFacade> results;

    public List<WebElementFacade> getResults() {
        return results;
    }
}
