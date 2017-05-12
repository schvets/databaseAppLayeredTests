package tools;

import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Dmytro Serdiuk (dmytro.serdiuk@gmail.com)
 * @since 17.03.2017
 */
public interface Context {

    WebElement element();

    List<WebElement> elements();
}
