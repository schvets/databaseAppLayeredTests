package tools;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

/**
 * class to represent the specifically wrapped WebElement(control).
 */
public class Control {
    /**
     * WebElement to be searched.
     */
    private final Context searchContext;

    /**
     * constructor with initialisation the <code>searchContext</code>.
     *
     * @param contextToSearch - WebElement to be searched.
     */
    public Control(final Context contextToSearch) {
        this.searchContext = contextToSearch;
    }

    public Control(WebElement webElement) {
        this(new WebElementContext(webElement));
    }

    /**
     * Click this element.
     * There are some preconditions for an element to be clicked. The element
     * must be visible and it must have a height and width greater then 0.
     */
    public final void click() {
        searchContext.element().click();
    }

    /**
     * If this element is a text entry element, this will clear the value.
     */
    public final void clear() {
        searchContext.element().clear();
    }

    /**
     * If this current element is a form, or an element within a form,
     * then this will be submitted to the remote server.
     * If this causes the current page to change, then this method will block
     * until the new page is loaded.
     */
    public final void submit() {
        searchContext.element().submit();
    }

    /**
     * Determine whether or not this element is selected or not.
     * This operation only applies to input elements such as
     * checkboxes, options in a select and radio buttons.
     *
     * @return True if the element is currently selected or checked,
     * false otherwise.
     */
    public final boolean isSelected() {
        return searchContext.element().isSelected();
    }

    /**
     * Is the element currently enabled or not? This will generally
     * return true for everything but disabled input elements.
     *
     * @return True if the element is enabled, false otherwise.
     */
    public final boolean isEnabled() {
        return searchContext.element().isEnabled();
    }

    /**
     * Is this element displayed or not? This method avoids the problem of
     * having to parse an element's "style" attribute.
     *
     * @return True if the element is displayed, false otherwise.
     */
    public final boolean isDisplayed() {
        try {
            return searchContext.element().isDisplayed();
        } catch (TimeoutException e){
            return false;
        }
    }

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element,
     * including sub-elements, without any leading or trailing whitespace.
     *
     * @return The innerText of this element.
     */
    public final String getText() {
        return searchContext.element().getText();
    }

    /**
     * Get the value of the "value" attribute of the current element.
     *
     * @return The current element "value" attribute's value
     * or null if the value is not set.
     */
    public final String getValue() {
        return searchContext.element().getAttribute("value");
    }

    /**
     * Simulates typing into an element, which may set its value.
     *
     * @param text - a string to send to the element
     */
    public final void sendKeys(final String text) {
        searchContext.element().sendKeys(text);
    }

    /**
     * Get the value of a the given attribute of the element.
     *
     * @param name - The name of the attribute.
     * @return The attribute/property's current value or null
     * if the value is not set.
     */
    public final String getAttribute(final String name) {
        return searchContext.element().getAttribute(name);
    }

}
