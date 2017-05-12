package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Button;
/**
 * @author Danil Zhyliaiev
 */

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class ButtonCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Button button;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aButton        control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public ButtonCriteria(final Button aButton,
                          final Specification aSpecification) {
        if (aButton == null) {
            throw new NotFoundException("the income Button == null");
        }
        button = aButton;
        specification = aSpecification;
    }

    /**
     * verify if the button is visible.
     *
     * @return ButtonCriteria
     */
    public ButtonCriteria isVisible() {
        specification.add(button.isDisplayed(), "The Button is not visible.");
        return this;
    }

    /**
     * verify if the button is enabled.
     *
     * @return ButtonCriteria
     */
    public ButtonCriteria isEnabled() {
        specification.add(button.isEnabled(), "The Button is not enabled.");
        return this;
    }

    /**
     * verify if the button is displayed.
     *
     * @return ButtonCriteria
     */
    public ButtonCriteria isDisabled() {
        specification.add(!button.isEnabled(), "The Button is not disabled.");
        return this;
    }

    /**
     * verify if the text of the button is as expectedText.
     *
     * @param expectedText String to compare with
     * @return ButtonCriteria
     */
    public ButtonCriteria textMatch(final String expectedText) {
        String actualText = this.button.getText();
        this.specification.add(
                expectedText.equals(actualText),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The Button text does not match",
                        expectedText, actualText));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
