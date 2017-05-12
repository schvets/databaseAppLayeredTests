package tools.controls.contracts;

/**
 * Contract fo the js-alert and js-confirm.
 */
public interface Alert {
    /**
     * Accept the alert.
     */
    void accept();

    /**
     * Dismiss the alert.
     */
    void dismiss();

    /**
     * Gets the alert text message.
     *
     * @return String - text of an alert.
     */
    String getText();
}
