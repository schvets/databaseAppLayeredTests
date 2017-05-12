package tools.controls;

import tools.Control;
import tools.controls.contracts.Checkbox;

/**
 * implementation of the Checkbox control for the web API.
 */
public class CheckboxImpl implements Checkbox {

    /**
     * control wrapped as Checkbox.
     */
    private Control control;

    /**
     * Constructor.
     * initialization of the <code>control</code> field.
     * <p>
     * could be private but is protected because of the usage in the
     * WebElementsList class.
     *
     * @param controlToWrapAsCheckbox control to wrap as Checkbox.
     */
   public CheckboxImpl(final Control controlToWrapAsCheckbox) {
        this.control = controlToWrapAsCheckbox;
    }

    @Override
    public final void check() {
        if (!control.isSelected()) {
            control.click();
        }
    }

    @Override
    public final void unCheck() {
        if (control.isSelected()) {
            control.click();
        }
    }

    @Override
    public final boolean isChecked() {
        return control.isSelected();
    }

    @Override
    public final boolean isEnabled() {
        return control.isEnabled();
    }
}
