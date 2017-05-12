package tools.controls;

import tools.Control;
import tools.controls.contracts.Button;

/**
 * implementation of the Button control for the web API.
 */
public class ButtonImpl implements Button {
    /**
     * control wrapped as Button.
     */
    private Control control;

    /**
     * Constructor.
     * initialization of the <code>control</code> field.
     * <p>
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param controlToWrapAsButton control to wrap as Button.
     */
    public ButtonImpl(final Control controlToWrapAsButton) {
        control = controlToWrapAsButton;
    }


    @Override
    public final boolean isDisplayed() {
        return control.isDisplayed();
    }

    @Override
    public final boolean isEnabled() {
        return control.isEnabled();
    }

    @Override
    public final String getText() {
        return control.getText();
    }


    @Override
    public final void click() {
        control.click();
    }
}
