package tools.controls.contracts;

/**
 * Determines the main functionality for the TextInput control.
 */
public interface TextInput extends Label {

    /**
     * Click this element.
     */
    void click();

    /**
     * If this element is a text entry element, this will clear the value.
     */
    void clear();

    /**
     * Simulates typing into an element, which may set its value.
     *
     * @param text - a string to send to the element
     */
    void type(String text);

    /**
     * TextInput's form will be submitted to the remote server.
     * If this causes the current page to change, then this method will block
     * until the new page is loaded.
     */
    void submit();
}
