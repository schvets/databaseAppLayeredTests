package tools.controls;

import tools.Select;
import tools.controls.contracts.Dropdown;

import java.util.List;

/**
 * implementation of the Dropdown control for the web API.
 *
 * @author Danil Zhyliaiev
 */
public class DropdownImpl implements Dropdown {

    /**
     * select wrapped as Dropdown.
     */
    private Select select;

    /**
     * Constructor.
     * initialization of the <code>select</code> field.
     * <p>
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param selectToWrap select to wrap as Dropdown.
     */
    public DropdownImpl(final Select selectToWrap) {
        select = selectToWrap;
    }

    @Override
    public final String getSelectedOptionIndex() {
        return select.getSelectedOptionIndex();
    }

    @Override
    public final String getSelectedOptionValue() {
        return select.getSelectedOptionValue();
    }

    @Override
    public final String getSelectedOptionText() {
        return select.getSelectedOptionText();
    }

    @Override
    public final List<String> getOptions() {
        return select.getOptions();
    }

    @Override
    public final boolean isEnabled() {
        return select.isEnabled();
    }

    @Override
    public final void selectByIndex(final int index) {
        select.selectByIndex(index);
    }

    @Override
    public final void selectByValue(final String value) {
        select.selectByValue(value);
    }

    @Override
    public final void selectByVisibleText(final String text) {
        select.selectByVisibleText(text);
    }
}
