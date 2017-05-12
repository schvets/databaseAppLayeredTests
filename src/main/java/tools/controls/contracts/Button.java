package tools.controls.contracts;

/**
 * Determines the main functionality for the Button control.
 */
public interface Button {

    /**
     * Is this element displayed or not? This method
     * avoids the problem of having to parse an element's "style" attribute.
     *
     * @return True if the element is displayed, false otherwise.
     */
    boolean isDisplayed();

    /**
     * Is the element currently enabled or not? This will generally return true
     * for everything but disabled input elements.
     *
     * @return True if the element is enabled, false otherwise.
     */
    boolean isEnabled();

    /**
     * Get the value of the "value" attribute of the Button element.
     *
     * @return The current Button "value" attribute's value(text)
     * or null if the value is not set.
     */
    String getText();


    /**
     * The button will be submitted to the remote server.
     * If this causes the current page to change, then
     * this method will block until the new page is loaded.
     */
    void click();
}
