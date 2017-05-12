package specification.criteria;

import org.openqa.selenium.NotFoundException;
import specification.Specifiable;
import specification.Specification;
/**
 * contains the methods which are the way the control can be validated.
 * and the mechanism for the writing down the validation errors to the
 * specification.
 */
public final class DigitCriteria implements Specifiable {
    /**
     * control to be validated with the <code>Criteria</code>.
     */
    private Double digit;
    /**
     * the Specification the validation result will be added to.
     */
    private Specification specification;

    /**
     * Constructor.
     *
     * @param aDigit         control to be validated with the
     *                       <code>Criteria</code>.
     * @param aSpecification the validation result will be added to it
     */
    public DigitCriteria(final Double aDigit,
                         final Specification aSpecification) {
        if (aDigit == null) {
            throw new NotFoundException("the income Integer == null");
        }

        digit = aDigit;
        specification = aSpecification;
    }

    /**
     * check if the income digit is not greater than max.
     *
     * @param max the digit to compare with
     * @return DigitCriteria
     */
    public DigitCriteria notGreaterThan(final Double max) {
        specification.add(digit <= max,
                String.format("The digit is greater than %.2f. ", max));
        return this;
    }

    /**
     * check if the income digit is not greater than max.
     *
     * @param expectedDigit the digit to compare with
     * @return DigitCriteria
     */
    public DigitCriteria valueMatch(final Double expectedDigit) {
        Double actualDigit = this.digit;
        specification.add(expectedDigit.equals(actualDigit),
                String.format("%s:%n  expected [%s]%n but found [%s]; ",
                        "The digit does not match",
                        expectedDigit, actualDigit));
        return this;
    }

    @Override
    public Specification next() {
        return this.specification;
    }
}
