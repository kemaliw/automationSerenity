package steps;

import org.fluentlenium.core.annotation.Page;
import pages.DuckHomePage;

public class DuckSteps {

    @Page
    DuckHomePage duckHomePage;

    public void openDuckPage(){
        duckHomePage.open();
    }
}
