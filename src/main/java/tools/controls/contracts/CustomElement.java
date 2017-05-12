package tools.controls.contracts;

/**
 * Class to represent custom web element as divs, spans etc.
 * <p>
 * Determines the main functionality for the CustomElement control.
 *
 * @author Danil Zhyliaiev
 */
public interface CustomElement {
    /**
     * Click this element.
     */
    void click();

    /**
     * If this element is a text entry element, this will clear the value.
     */
    void clear();

    /**
     * If this current element is a form, or an element within a form,
     * then this will be submitted to the remote server.
     * If this causes the current page to change, then this method will block
     * until the new page is loaded.
     */
    void submit();

    /**
     * Determine whether or not this element is selected or not.
     * This operation only applies to input elements such as
     * checkboxes, options in a select and radio buttons.
     *
     * @return True if the element is currently selected or checked,
     * false otherwise.
     */
    boolean isSelected();

    /**
     * Is the element currently enabled or not? This will generally
     * return true for everything but disabled input elements.
     *
     * @return True if the element is enabled, false otherwise.
     */
    boolean isEnabled();

    /**
     * Is this element displayed or not? This method avoids the problem of
     * having to parse an element's "style" attribute.
     *
     * @return True if the element is displayed, false otherwise.
     */
    boolean isDisplayed();

    /**
     * Get the visible (i.e. not hidden by CSS) innerText of this element,
     * including sub-elements, without any leading or trailing whitespace.
     *
     * @return The innerText of this element.
     */
    String getText();

    /**
     * Simulates typing into an element, which may set its value.
     *
     * @param text - a string to send to the element
     */
    void sendKeys(String text);
}
