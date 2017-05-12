package tools;


import org.openqa.selenium.Alert;

/**
 * class to represent the tool to work with js-alert and js-confirm.
 */
public class AlertWrapper {
    /**
     * an alert to work with.
     */
    private Alert alert;

    /**
     * Constructor.
     * initialisation of the <code>alert</code>.
     *
     * @param seleniumAlert to handle(wrap)
     */
    public AlertWrapper(final Alert seleniumAlert) {
        alert = seleniumAlert;
    }

    /**
     * accessor.
     * gets the <code>alert</code> instance.
     *
     * @return the <code>alert</code> instance.
     */
    public final Alert get() {
        return alert;
    }

    /**
     * Accept the alert.
     */
    public final void accept() {
        get().accept();
    }

    /**
     * Dismiss the alert.
     */
    public final void dismiss() {
        get().dismiss();
    }

    /**
     * Gets the alert text message.
     *
     * @return String - text of an alert.
     */
    public final String getText() {
        return get().getText();
    }
}
