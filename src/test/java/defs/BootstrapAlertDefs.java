package defs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BootstrapAlertPage;

import java.time.Duration;
import java.util.List;

public class BootstrapAlertDefs extends UIInteractionSteps {

    private Logger LOGGER = LoggerFactory.getLogger(BootstrapAlertDefs.class);

    @Page
    BootstrapAlertPage bootstrapAlertPage;

    @And("Click on alert button - autoclosable")
    public void clickOnAlertButtonAutoclosable(DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            String id = row.get("id");
            $(By.id(id)).click();
            String expectedPopup = row.get("Expected popup");
            LOGGER.info("Expected popup: {}", expectedPopup);
            WebElementFacade alert = $(By.xpath("//div[contains(@class,'alert')][contains(text(),'" + expectedPopup + "')]"));
            LOGGER.info("Status displayed: {}", alert.isDisplayed());
            alert.waitUntilVisible();
            waitUntilNotDisplayed(7, alert);
        });
    }

    @And("Click on alert button - normal")
    public void clickOnAlertButtonNormal(DataTable dataTable) {
        dataTable.asMaps().forEach(row -> {
            String id = row.get("id");
            $(By.id(id)).click();
            String expectedPopup = row.get("Expected popup");
            WebElementFacade alert = $(By.xpath("//div[contains(@class,'alert')][text()[contains(normalize-space(.),'" + expectedPopup + "')]]"));
            alert.thenFind("button").click();
            Assert.assertFalse("Alert is displayed", alert.isDisplayed());
        });
    }

    @And("Click on alert buttons")
    public void clickOnAlertButtons() {
        bootstrapAlertPage.getAlertButtons().forEach(WebElementFacade::click);
        getAutocloseableAlerts().forEach(WebElementFacade::isDisplayed);
    }

    @Then("Autoclosable alerts are closed after {int} seconds")
    public void autoclosableAlertsAreClosedAfterSeconds(int seconds) {
        SoftAssertions softAssertions = new SoftAssertions();
        getAutocloseableAlerts()
                .parallelStream()
                .forEach(alert -> {
                    boolean isDisplayed = false;
                    try {
                        isDisplayed = waitUntilNotDisplayed(seconds, alert);

                    } catch (Exception ignored) {
                    }
                    System.out.println("isDisplayed = " + isDisplayed);
                    softAssertions.assertThat(isDisplayed).as(alert.getText()).isTrue();
                });
        softAssertions.assertAll();
    }

    @And("Normal alerts remain opened")
    public void normalAlertsRemainOpened() {
        SoftAssertions softAssertions = new SoftAssertions();
        getNormalAlerts().parallelStream().forEach(alert ->
                softAssertions.assertThat(alert.isDisplayed()).as(alert.getText()).isTrue());
        softAssertions.assertAll();
    }

    @And("User close normal alerts")
    public void userCloseNormalAlerts() {
        SoftAssertions softAssertions = new SoftAssertions();
        getNormalAlerts().forEach(alert -> {
            alert.thenFind("button").click();
            softAssertions.assertThat(alert.isDisplayed()).as(alert.getText()).isFalse();
        });
        softAssertions.assertAll();
    }

    private List<WebElementFacade> getNormalAlerts() {
        return bootstrapAlertPage.getAlertByText("normal");
    }

    private List<WebElementFacade> getAutocloseableAlerts() {
        return bootstrapAlertPage.getAlertByText("autocloseable");
    }

    private Boolean waitUntilNotDisplayed(int seconds, WebElementFacade alert) {
        return waitForCondition().withTimeout(Duration.ofSeconds(seconds)).until(WebDriver -> !alert.isDisplayed());
    }
}
