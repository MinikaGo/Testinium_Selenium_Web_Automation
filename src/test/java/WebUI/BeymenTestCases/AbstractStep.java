package WebUI.BeymenTestCases;

import WebUI.utils.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractStep {

    WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

    protected boolean isElementDisplayed(WebElement element) {
        boolean present = false;
        try {
            present = element.isDisplayed();
        } catch (Exception ignored) {
        }
        return present;
    }


    protected void sendEnterButtonAction(WebElement element) {

        element.sendKeys(Keys.ENTER);


    }

    protected void clear(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            js.executeScript("arguments[0].value='';", element);
        } catch (ElementNotInteractableException ignored) {
        }
    }

    public void waitForPageReload() {
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void selectElementFromDropDown(WebElement element, String visibleText) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            Select slc = new Select(element);
            slc.selectByVisibleText(visibleText);
        } catch (NoSuchElementException ignored) {
        }
    }
}
