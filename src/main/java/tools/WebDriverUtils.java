package tools;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import specification.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * The main class for the WebDriver initialization and WebDriver configuration.
 * contains the methods to access the WebDriver instance
 */
public final class WebDriverUtils {
    /**
     * timeout in seconds.
     * time to start to search for the element after.
     */
    public final int ABSENCE_TIMEOUT = 5;
    /**
     * implicit timeout in seconds.
     * time to wait for the element is loaded on the page.
     */
    private final long IMPLICITLY_WAIT_TIMEOUT = 4;
    private final long IMPLICITLY_LONG_WAIT_TIMEOUT = 20;
    /**
     * contains a WebDriver object.
     */
    private static WebDriver driver;
    
    /**
     * suppressed constructor.
     * in order to avoid creating the WebDriverUtils object with using the
     * "new" word from the outside (instance can me created inside the
     * WebDriverUtils only) and reject the extension of the
     * WebDriverUtils object.
     */
    public WebDriverUtils() {
    }
    
    /**
     * creating and configuring the WebDriver object.
     * accessor, singleton.
     *
     * @return FirefoxDriver instance
     */
    public WebDriver getDriver()  {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            try {
                driver = new RemoteWebDriver(new URL(new TestConfig().getLocalPort()), capabilities);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(
                    getImplicitlyWaitTimeout(), TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
    
    /**
     * getter fo the implicitlyWaitTimeout.
     * accessor.
     *
     * @return long implicitlyWaitTimeout
     */
    long getImplicitlyWaitTimeout() {
        return IMPLICITLY_WAIT_TIMEOUT;
    }

    long getImplicitlyLongWaitTimeout() {
        return IMPLICITLY_LONG_WAIT_TIMEOUT;
    }
    
    /**
     * loads the specified page(url) to the WebDriver.
     *
     * @param path url to navigate driver to, better to use fully qualified.
     */
    public void load(final String path) {
        getDriver().navigate().to(path);
    }
    
    /**
     * Close the current window,
     * quitting the browser if it's the last window currently open.
     */
    public void stop() {
        if (driver != null) {
            try {
                driver.manage().deleteAllCookies();
                driver.close();
            } catch (UnhandledAlertException e) {
                String errorMessage = e.getMessage();
                while (! errorMessage.equals("")) {
                    try {
                        driver.close();
                        errorMessage = "";
                    } catch (UnhandledAlertException e1) {
                        errorMessage = e1.getMessage();
                    }
                }
                driver = null;
                throw new UnhandledAlertException(e.getMessage());
            }
        }
        driver = null;
    }
    
    public void refresh() {
        getDriver().navigate().refresh();
    }
    
    /**
     * Get a string representing the current URL that the browser is looking at.
     *
     * @return the URL of the page currently loaded in the browser
     */
    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
    
    /**
     * gets the title of the current page.
     *
     * @return the title of the current page,
     * with leading and trailing whitespace stripped,
     * or null if one is not already set
     */
    public String getTitle() {
        return getDriver().getTitle();
    }
    
    public void switchToNewWindow() {
        java.util.Set<String> handles = driver.getWindowHandles();
        for (String handle1 : driver.getWindowHandles()) {
            getDriver().switchTo().window(handle1);
            getDriver().manage().window().maximize();
            
        }
    }

}
