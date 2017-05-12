package tools.controls.contracts;

/**
 * Determines the main functionality for the Label control.
 */
public interface Label {

    /**
     * Is this element displayed or not?
     *
     * @return True if the element is displayed, false otherwise.
     */
    boolean isDisplayed();

    /**
     * Get the visible innerText of this element.
     *
     * @return The innerText of this element.
     */
    String getText();

}
