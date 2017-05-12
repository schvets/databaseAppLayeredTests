package tools;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * class to represent the specifically wrapped the Select selenium webElement.
 *
 * @author Danil Zhyliaiev
 */
public class Select extends Control {
    /**
     * the "Select selenium webElement" to be wrapped.
     */
    private org.openqa.selenium.support.ui.Select select;

    /**
     * Constructor.
     * A check is made that the given element is visible and is, indeed,
     * a SELECT tag.
     * If it is not, then an UnexpectedTagNameException is thrown.
     *
     * @param contextToSearch -the element to be specified as a Select tag.
     */
    public Select(final Context contextToSearch) {
        super(contextToSearch);
        this.select = new org.openqa.selenium.support.ui.Select(contextToSearch.element());
    }

    public Select(WebElement webElement) {
        super(new WebElementContext(webElement));
    }

    /**
     * accessor.
     *
     * @return the Select to be wrapped.
     */
    private org.openqa.selenium.support.ui.Select getSelect() {
        return select;
    }

    /**
     * Clear all selected entries.
     * This is only valid when the SELECT supports multiple selections.
     */
    public final void deselectAll() {
        getSelect().deselectAll();
    }

    /**
     * Deselect the option at the given index.
     * This is done by examining the "index" attribute of an element,
     * and not merely by counting.
     *
     * @param index - The option at this index will be deselected
     */
    public final void deselectByIndex(final int index) {
        getSelect().deselectByIndex(index);
    }

    /**
     * Deselect all options that have a value matching the argument.
     * That is, when given "foo" this would deselect an option
     * like: &#60option value="foo">Bar&#60/option>.
     *
     * @param value - The value to match against
     */
    public final void deselectByValue(final String value) {
        getSelect().deselectByValue(value);
    }

    /**
     * Deselect all options that display text matching the argument.
     * That is, when given "Bar" this would deselect an option like:
     * &#60option value="foo">Bar&#60/option>
     *
     * @param text - The visible text to match against
     */
    public final void deselectByVisibleText(final String text) {
        getSelect().deselectByVisibleText(text);
    }

    /**
     * gets selected options belonging to this select tag as a List&#60String>.
     *
     * @return List&#60String>
     */
    public final List<String> getAllSelectedOptions() {
        List<String> selectedOptions = new ArrayList<>();
        for (WebElement option : getSelect().getAllSelectedOptions()) {
            selectedOptions.add(option.getText());
        }
        return selectedOptions;
    }

    /**
     * @return - The first selected option in this select tag
     * (or the currently selected option in a normal select)
     */
    public final WebElement getFirstSelectedOption() {
        return getSelect().getFirstSelectedOption();
    }

    /**
     * @return the "index" attribute of the first selected option.
     */
    public final String getSelectedOptionIndex() {
        return getSelect().getFirstSelectedOption().getAttribute("index");
    }

    /**
     * @return the "value" attribute of the first selected option.
     */
    public final String getSelectedOptionValue() {
        return getSelect().getFirstSelectedOption().getAttribute("value");
    }

    /**
     * @return the inner text of the first selected option.
     */
    public final String getSelectedOptionText() {
        return getSelect().getFirstSelectedOption().getText();
    }

    /**
     * gets the list of the options of the Select tag.
     *
     * @return List&#60String>
     */
    public final List<String> getOptions() {
        List<String> options = new ArrayList<>();
        for (WebElement option : getSelect().getOptions()) {
            options.add(option.getText());
        }
        return options;
    }

    /**
     * @return Whether this select element support selecting multiple options
     * at the same time? This is done by checking the value of
     * the "multiple" attribute.
     */
    public final boolean isMultiple() {
        return getSelect().isMultiple();
    }

    /**
     * Select the option at the given index.
     * This is done by examining the "index" attribute of an element,
     * and not merely by counting.
     *
     * @param index - The option at this index will be selected
     */
    public final void selectByIndex(final int index) {
        getSelect().selectByIndex(index);
    }

    /**
     * Select all options that have a value matching the argument. That is,
     * when given "foo" this would select an option like:
     * &#60option value="foo">Bar&#60/option>
     *
     * @param value - The value to match against
     */
    public final void selectByValue(final String value) {
        getSelect().selectByValue(value);
    }

    /**
     * Select all options that display text matching the argument.
     * That is, when given "Bar" this would select an option like:
     * &#60option value="foo">Bar&#60/option>
     *
     * @param text - The visible text to match against
     */
    public final void selectByVisibleText(final String text) {
        getSelect().selectByVisibleText(text);
    }
}
