package defs;

import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AllegroDefs extends UIInteractionSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllegroDefs.class);

    @Then("User can wait until day offer ends in {int} hours {int} minutes")
    public void userCanWaitUntilDayOfferEndsInHoursMinutes(int hours, int minutes) {
        WebElementFacade popupCloseButton = $(By.cssSelector("img[alt=zamknij]"));
        WebElementFacade offerCounter = $(By.cssSelector("[data-template=counter]"));
        WebElementFacade hoursElement = offerCounter.thenFind("[data-role=opbox-countdown-hours]");
        WebElementFacade minutesElement = offerCounter.thenFind("[data-role=opbox-countdown-minutes]");
        popupCloseButton.waitUntilVisible().click();
        waitForCondition()
                .withTimeout(Duration.ofMinutes(30))
                .pollingEvery(Duration.ofSeconds(10))
                .until(webDriver -> {
                    LocalTime offerTime = LocalTime.parse(hoursElement.getText() + minutesElement.getText(), DateTimeFormatter.ofPattern("HH:mm:"));
                    LOGGER.info("Current offer time is {}", offerTime);
                    return offerTime.getHour() == hours && offerTime.getMinute() == minutes;
                });
    }
}
