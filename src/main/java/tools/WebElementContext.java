package tools;

import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
class WebElementContext implements Context {
    private final WebElement webElement;

    public WebElementContext(WebElement webElement) {
        this.webElement = webElement;
    }

    @Override
    public WebElement element() {
        return webElement;
    }

    @Override
    public List<WebElement> elements() {
        return Collections.singletonList(webElement);
    }

}
