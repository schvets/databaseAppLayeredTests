package tools.controls.contracts;

/**
 * @author Danil Zhyliaiev
 */

import java.util.List;

/**
 * Determines the main functionality for the Dropdown control.
 */
public interface Dropdown {

    /**
     * @return The "index" attribute of the first selected option.
     */
    String getSelectedOptionIndex();

    /**
     * @return The "value" attribute of the first selected option.
     */
    String getSelectedOptionValue();

    /**
     * @return The inner text of the first selected option.
     */
    String getSelectedOptionText();

    /**
     * gets the list of the options of the Select tag.
     *
     * @return List&#60String>
     */
    List<String> getOptions();

    /**
     * Is the element currently enabled or not?
     * This will generally return true for everything but disabled input
     * elements.
     *
     * @return True if the element is enabled, false otherwise.
     */
    boolean isEnabled();

    /**
     * Select the option at the given index.
     * This is done by examining the "index" attribute of an element,
     * and not merely by counting.
     *
     * @param index The option at this index will be selected
     */
    void selectByIndex(int index);

    /**
     * Select all options that have a value matching the argument.
     * That is, when given "foo" this would select an option like:
     * &#60option value="foo">Bar&#60/option>
     *
     * @param value The value to match against
     */
    void selectByValue(String value);

    /**
     * Select all options that display text matching the argument.
     * That is, when given "Bar" this would select an option like:
     * &#60option value="foo">Bar&#60/option>
     *
     * @param text The visible text to match against
     */
    void selectByVisibleText(String text);
}
