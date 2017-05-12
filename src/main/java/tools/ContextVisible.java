package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * a tool to element the visible WebElement from the document(page).
 *
 * @author Danil Zhyliaiev
 */
public final class ContextVisible implements Context {

    private final By by;

    public ContextVisible(By by) {
        this.by = by;
    }

    /**
     * if the current document(page) contains the element specified by income
     * <code>ControlLocation</code> it will be returned.
     * NoSuchElementException or TimeoutException will be thrown if the element
     * is not found on the page.
     *
     * @return WebElement specified by income <code>ControlLocation</code>.
     */
    @Override
    public WebElement element() {
        WebDriverWait wait = new WebDriverWait(
                new WebDriverUtils().getDriver(),
                new WebDriverUtils().getImplicitlyWaitTimeout());

        WebElement webElement = wait.until(
                ExpectedConditions.
                        visibilityOfElementLocated(by));

        if (webElement == null) {
            throw new NoSuchElementException(String.format("Error %s", by));
        }

        return webElement;
    }

    /**
     * Used to element a list of visible web elements that match the
     * given ControlLocation.
     *
     * @return List of visible WebElements found by given locator.
     */
    @Override
    public List<WebElement> elements() {
        turnOffTimeouts();
        List<WebElement> webElements = new WebDriverUtils().getDriver()
                .findElements(by);
        turnOnTimeouts();

        if (webElements.size() != 0) {
            WebDriverWait wait = new WebDriverWait(
                    new WebDriverUtils().getDriver(),
                    0);

            webElements = wait.until(
                    ExpectedConditions
                            .visibilityOfAllElementsLocatedBy(
                                    by));

            if (webElements == null) {
                throw new NoSuchElementException(String.format("Error %s", by));
            }
        }

        return webElements;
    }

    /**
     * sets the driver implicitlyWait to 0(zero).
     */
    private void turnOffTimeouts() {
        new WebDriverUtils().getDriver().manage().timeouts()
                .implicitlyWait(0, TimeUnit.SECONDS);
    }

    /**
     * sets the driver implicitlyWait to the specified in the WebDriverUtils
     * one.
     */
    private void turnOnTimeouts() {
        new WebDriverUtils().getDriver().manage().timeouts()
                .implicitlyWait(new WebDriverUtils().getImplicitlyWaitTimeout(),
                        TimeUnit.SECONDS);
    }
}
