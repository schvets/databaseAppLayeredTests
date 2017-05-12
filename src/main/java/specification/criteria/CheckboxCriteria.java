package specification.criteria;


import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
import tools.controls.contracts.Checkbox;

/**
 * Author S.Tsiganovskiy
 */

/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class CheckboxCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Checkbox checkbox;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aCheckbox      control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public CheckboxCriteria(final Checkbox aCheckbox,
                            final Specification aSpecification) {
        if (aCheckbox == null) {
            throw new NotFoundException("the income Checkbox == null");
        }
        checkbox = aCheckbox;
        specification = aSpecification;
    }

    /**
     * Verify if the checkbox is checked.
     *
     * @return CheckboxCriteria
     */
    public CheckboxCriteria isChecked() {
        specification.add(checkbox.isChecked(),
                "The Checkbox is not checked.");
        return this;
    }

    /**
     * Verify if the checkbox is unchecked.
     *
     * @return CheckboxCriteria
     */
    public CheckboxCriteria isUnChecked() {
        specification.add(!checkbox.isChecked(), "The Checkbox is checked.");
        return this;
    }

    /**
     * Verify if the checkbox is enabled.
     *
     * @return CheckboxCriteria
     */
    public CheckboxCriteria isEnabled() {
        specification.add(checkbox.isEnabled(), "The Checkbox is disabled.");
        return this;
    }

    /**
     * Verify if the checkbox status is as expectedStatus.
     *
     * @param expectedStatus expected checkbox status.
     * @return CheckboxCriteria
     */
    public CheckboxCriteria statusMatch(final boolean expectedStatus) {
        boolean actualStatus = checkbox.isChecked();
        specification.add(actualStatus == expectedStatus,
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "Invalid checkbox status",
                        expectedStatus, actualStatus));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
