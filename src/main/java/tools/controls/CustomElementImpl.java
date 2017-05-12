package tools.controls;

import tools.Control;
import tools.controls.contracts.CustomElement;

/**
 * Class to represent custom div and elements.
 * <p>
 * implementation of the CustomElement control for the web API.
 *
 * @author Danil Zhyliaiev
 */
public class CustomElementImpl implements CustomElement {

    /**
     * control wrapped as CustomElement.
     */
    private Control control;

    /**
     * Constructor.
     * initialization of the <code>control</code> field.
     * <p>
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param controlToWrap control to wrap as CustomElement.
     */
    public CustomElementImpl(final Control controlToWrap) {
        control = controlToWrap;
    }

    @Override
    public final void click() {
        control.click();
    }

    @Override
    public final void clear() {
        control.clear();
    }

    @Override
    public final void submit() {
        control.submit();
    }

    @Override
    public final boolean isSelected() {
        return control.isSelected();
    }

    @Override
    public final boolean isEnabled() {
        return control.isEnabled();
    }

    @Override
    public final boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public final String getText() {
        return control.getText();
    }

    @Override
    public final void sendKeys(final String text) {
        control.sendKeys(text);
    }
}
