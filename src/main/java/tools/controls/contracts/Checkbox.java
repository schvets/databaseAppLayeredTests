package tools.controls.contracts;

/**
 * Determines the main functionality for the Checkbox control.
 */
public interface Checkbox {

    /**
     * Click the Checkbox element if it is not checkedOff(selected)
     * in order to checkOff it.
     */
    void check();

    /**
     * Click the Checkbox element if it is checkedOff(selected)
     * in order to unCheck it.
     */
    void unCheck();

    /**
     * Determine whether or not this element is checkedOff or not.
     * This operation only applies to input elements such as checkboxes,
     * options in a select and radio buttons.
     *
     * @return True if the Checkbox is currently checkedOff,
     * false otherwise.
     */
    boolean isChecked();

    /**
     * Is the Checkbox currently enabled or not?
     *
     * @return True if the Checkbox is enabled, false otherwise.
     */
    boolean isEnabled();
}
